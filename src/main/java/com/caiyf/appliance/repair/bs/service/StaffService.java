package com.caiyf.appliance.repair.bs.service;

import com.caiyf.appliance.repair.bs.dao.*;
import com.caiyf.appliance.repair.bs.exception.BusinessException;
import com.caiyf.appliance.repair.bs.model.bo.StaffBo;
import com.caiyf.appliance.repair.bs.model.bo.StaffInfoBo;
import com.caiyf.appliance.repair.bs.model.bo.User;
import com.caiyf.appliance.repair.bs.model.po.StaffInfoPo;
import com.caiyf.appliance.repair.bs.model.po.StaffLevelPo;
import com.caiyf.appliance.repair.bs.model.po.StaffPo;
import com.caiyf.appliance.repair.bs.model.po.StaffTypePo;
import com.caiyf.appliance.repair.bs.model.result.CodeEnum;
import com.caiyf.appliance.repair.bs.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc 员工service
 * @date 2019/04/21
 * @author caiyf
 */
@Service
public class StaffService {

    @Autowired
    private StaffTypeMapper staffTypeMapper;
    @Autowired
    private StaffLevelMapper staffLevelMapper;
    @Autowired
    private StaffInfoMapper staffInfoMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private EducationMapper educationMapper;
    @Autowired
    private MarriageMapper marriageMapper;
    @Autowired
    private NationMapper nationMapper;
    @Autowired
    private SexMapper sexMapper;

    /**
     * 获取员工类型列表
     * @return
     */
    public List<StaffTypePo> getStaffTypeList() {
        return staffTypeMapper.getAllPo();
    }

    /**
     * 获取员工级别列表
     * @return
     */
    public List<StaffLevelPo> getStaffLevelList() {
        return staffLevelMapper.getAllPo();
    }

    /**
     * 员工注册
     */
    public void initStaff() {

    }

    /**
     * 获取所有员工
     * @return
     */
    public List<StaffBo> getAllStaff() {

        return null;
    }

    /**
     * 获取员工信息
     * @param id
     * @return
     */
    public StaffInfoBo getStaffInfoById(Long id) {
        StaffInfoBo staffInfoBo = new StaffInfoBo();
        StaffInfoPo staffInfoPo = staffInfoMapper.getPoById(id);
        String education = educationMapper.getEducationById(staffInfoPo.getEducationId());
        staffInfoBo.setEducation(education);
        String marriage = marriageMapper.getMarriageById(staffInfoPo.getMarriageId());
        staffInfoBo.setMarriage(marriage);
        String nation = nationMapper.getNationById(staffInfoPo.getNationId());
        staffInfoBo.setNation(nation);
        String sex = sexMapper.getSexById(staffInfoPo.getSexId());
        staffInfoBo.setSex(sex);
        return staffInfoBo;
    }

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user) {
        if (null == user) {
            throw new BusinessException(CodeEnum.NULL_USER);
        }
        if (null == user.getNum()) {
            throw new BusinessException(CodeEnum.NULL_NUM);
        }
        if (null == user.getPassword()) {
            throw new BusinessException(CodeEnum.NULL_PASSWORD);
        }
        StaffPo staffPo = staffMapper.getPoByNum(user.getNum());
        if (staffPo == null) {
            throw new BusinessException(CodeEnum.NOT_EXIST_USER);
        }
        String userPassword = user.getPassword();
        String staffPassword = EncryptUtil.decrypt(staffPo.getPasswordEncrypt());
        if (!userPassword.equals(staffPassword)) {
            throw new BusinessException(CodeEnum.PASSWORD_ERROR);
        }
        user.setUserName(staffPo.getName());
        return user;
    }

}
