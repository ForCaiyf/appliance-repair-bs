package com.caiyf.appliance.repair.bs.wechat;

import com.caiyf.appliance.repair.bs.model.request.WxyyRequest;
import com.caiyf.appliance.repair.bs.model.response.WeChatLoginResponse;
import com.caiyf.appliance.repair.bs.model.result.Result;
import com.caiyf.appliance.repair.bs.service.WeChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @desc 微信用户相关controller
 * @date 2019/05/10
 * @author caiyf
 */
@RestController
@RequestMapping("/wechat")
@Api(value = "wechat", description = "微信用户管理")
public class WeChatController {

    @Autowired
    private WeChatService weChatService;

    @GetMapping("/login")
    @ApiOperation(value = "login", notes = "登录")
    public Result login(@RequestParam("code") String code) {
        WeChatLoginResponse response = weChatService.getOpenId(code);
        return Result.getSuccessResult(response);
    }

    @PostMapping("/wxyy")
    @ApiOperation(value = "wxyy", notes = "维修预约接口")
    public Result wxyy(@RequestBody WxyyRequest request, @RequestHeader("openId") String openId) {
        weChatService.wxyy(request, openId);
        return Result.getSuccessResult(true);
    }

}
