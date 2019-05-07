package com.caiyf.appliance.repair.bs.controller;

import com.caiyf.appliance.repair.bs.model.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 员工相关controller
 * @date 2019/04/26
 * @author caiyf
 */
@RestController
@RequestMapping("/admin/staff")
@Api(value = "admin-staff", description = "员工管理")
public class StaffController {

    @PostMapping("/login")
    @ApiOperation(value = "login", notes = "登录")
    public Result login() {
        return null;
    }

    @PostMapping("/logout")
    @ApiOperation(value = "logout", notes = "注销")
    public Result logout() {
        return null;
    }

    @PostMapping("/init")
    @ApiOperation(value = "init", notes = "创建员工")
    public Result init() {
        return null;
    }

    @PostMapping("/update-password")
    @ApiOperation(value = "update-password", notes = "更改密码")
    public Result updatePassword() {
        return null;
    }

    @PostMapping("/update- info")
    @ApiOperation(value = "update-info", notes = "更新员工信息")
    public Result updateInfo() {
        return null;
    }

}
