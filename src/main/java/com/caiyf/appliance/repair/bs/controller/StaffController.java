package com.caiyf.appliance.repair.bs.controller;

import com.caiyf.appliance.repair.bs.model.result.Result;
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
public class StaffController {

    @PostMapping("/login")
    public Result login() {
        return null;
    }

    @PostMapping("/logout")
    public Result logout() {
        return null;
    }

    @PostMapping("/init")
    public Result init() {
        return null;
    }

    @PostMapping("/update-password")
    public Result updatePassword() {
        return null;
    }

    @PostMapping("/update- info")
    public Result updateInfo() {
        return null;
    }

}
