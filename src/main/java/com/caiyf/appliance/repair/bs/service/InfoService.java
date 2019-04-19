package com.caiyf.appliance.repair.bs.service;

import com.caiyf.appliance.repair.bs.dao.*;
import com.caiyf.appliance.repair.bs.exception.BusinessException;
import com.caiyf.appliance.repair.bs.model.constant.DBConstant;
import com.caiyf.appliance.repair.bs.model.po.*;
import com.caiyf.appliance.repair.bs.model.result.CodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc 信息service（性别、学历、地区等）
 * @date 2019/04/19
 * @author caiyf
 */
@Slf4j
@Service
public class InfoService {

    @Autowired
    private SexMapper sexMapper;
    @Autowired
    private EducationMapper educationMapper;
    @Autowired
    private MarriageMapper marriageMapper;
    @Autowired
    private NationMapper nationMapper;
    @Autowired
    private RegionMapper regionMapper;

    /**
     * 获取性别列表
     * @return
     */
    public List<SexPo> getSexList() {
        return sexMapper.getAllPo();
    }

    /**
     * 获取学历列表
     * @return
     */
    public List<EducationPo> getEducationList() {
        return educationMapper.getAllPo();
    }

    /**
     * 获取婚姻状况列表
     * @return
     */
    private List<MarriagePo> getMarriageList() {
        return marriageMapper.getAllPo();
    }

    /**
     * 获取民族列表
     * @return
     */
    public List<NationPo> getNationList() {
        return nationMapper.getAllPo();
    }

    /**
     * 获取省份列表
     * @return
     */
    public List<RegionPo> getProvinceList() {
        return regionMapper.getPoListByType(DBConstant.REGION_TYPE_PROVINCE);
    }

    /**
     * 通过上一级获得对应地区信息（省->市、市->区县）
     * @param parentId
     * @return
     */
    public List<RegionPo> getRegionListByParentId(Integer parentId) {
        List<RegionPo> regionList = regionMapper.getPoListByParentId(parentId);
        if (regionList.isEmpty()) {
            log.error("[null region error] with parentId: {}", parentId);
            throw new BusinessException(CodeEnum.NULL_REGION_ERROR);
        }
        return regionList;
    }

    /**
     * 根据区县id及街道信息获取完整地址
     * @param districtId
     * @param streetInfo
     * @return
     */
    public String getCompleteAddress(Integer districtId, String streetInfo) {
        RegionPo district = regionMapper.getPoById(districtId);
        if (district == null) {
            log.error("[null region error] with id: {}", districtId);
            throw new BusinessException(CodeEnum.NULL_REGION_ERROR);
        }
        RegionPo city = regionMapper.getPoById(district.getParentId());
        RegionPo province = regionMapper.getPoById(city.getParentId());
        StringBuilder completeAddress = new StringBuilder();
        completeAddress.append(province.getName()).append("|")
                .append(city.getName()).append("|")
                .append(district.getName()).append("|")
                .append(streetInfo);
        return completeAddress.toString();
    }

}
