package com.caiyf.appliance.repair.bs.wechat;

import com.caiyf.appliance.repair.bs.model.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @desc 微信用户相关controller
 * @date 2019/05/10
 * @author caiyf
 */
@RestController
@RequestMapping("/wechat/user")
@Api(value = "wechat-user", description = "微信用户管理")
public class UserController {

    @GetMapping("/login")
    @ApiOperation(value = "login", notes = "登录")
    public Result login(@RequestParam("code") String code) {
        System.out.println(code);
        return null;
    }

}
