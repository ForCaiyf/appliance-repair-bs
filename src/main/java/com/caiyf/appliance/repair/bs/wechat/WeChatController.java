package com.caiyf.appliance.repair.bs.wechat;

import com.caiyf.appliance.repair.bs.model.po.GoodsPo;
import com.caiyf.appliance.repair.bs.model.po.OrderPo;
import com.caiyf.appliance.repair.bs.model.po.RepairShopPo;
import com.caiyf.appliance.repair.bs.model.request.JswxRequest;
import com.caiyf.appliance.repair.bs.model.request.PjRequest;
import com.caiyf.appliance.repair.bs.model.request.WxyyRequest;
import com.caiyf.appliance.repair.bs.model.response.OrderDetailResponse;
import com.caiyf.appliance.repair.bs.model.response.WeChatLoginResponse;
import com.caiyf.appliance.repair.bs.model.result.Result;
import com.caiyf.appliance.repair.bs.service.WeChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/jdck")
    @ApiOperation(value = "jdck", notes = "进度查看接口")
    public Result jdck(@RequestHeader("openId") String openId) {
        OrderPo response = weChatService.jdck(openId);
        return Result.getSuccessResult(response);
    }

    @PostMapping("/jswx")
    @ApiOperation(value = "jswx", notes = "极速维修接口")
    public Result jswx(@RequestBody JswxRequest request, @RequestHeader("openId") String openId) {
        weChatService.jswx(request, openId);
        return Result.getSuccessResult(true);
    }

    @GetMapping("/sdwx")
    @ApiOperation(value = "sdwx", notes = "送店维修接口")
    public Result sdwx() {
        List<RepairShopPo> response = weChatService.sdwx();
        return Result.getSuccessResult(response);
    }

    @GetMapping("/jdtj")
    @ApiOperation(value = "jdtj", notes = "家电推荐接口")
    public Result jdtj() {
        List<GoodsPo> response = weChatService.jdtj();
        System.out.println(response);
        return Result.getSuccessResult(response);
    }

    @GetMapping("/order-list")
    @ApiOperation(value = "order-list", notes = "订单列表接口")
    public Result orderList(@RequestHeader("openId") String openId) {
        List<OrderPo> response = weChatService.getOrderList(openId);
        return Result.getSuccessResult(response);
    }

    @GetMapping("/order-detail")
    @ApiOperation(value = "order-detail", notes = "订单详情接口")
    public Result orderDetail(@RequestHeader("id") Long id) {
        OrderDetailResponse response = weChatService.getOrderDetail(id);
        return Result.getSuccessResult(response);
    }

    @PostMapping("/order-pj")
    @ApiOperation(value = "order-pj", notes = "订单评价接口")
    public Result orderPj(@RequestBody PjRequest request, @RequestHeader("id") Long id) {
        weChatService.orderPj(request, id);
        return Result.getSuccessResult(true);
    }

}
