package com.caiyf.appliance.repair.bs.controller;

import com.caiyf.appliance.repair.bs.model.po.OrderFeedback;
import com.caiyf.appliance.repair.bs.model.request.FpOrderRequest;
import com.caiyf.appliance.repair.bs.model.response.AllOrderResponse;
import com.caiyf.appliance.repair.bs.model.response.FdcResponse;
import com.caiyf.appliance.repair.bs.model.response.MyOrderResponse;
import com.caiyf.appliance.repair.bs.model.response.SummaryRequest;
import com.caiyf.appliance.repair.bs.model.result.Result;
import com.caiyf.appliance.repair.bs.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @desc 订单相关controller
 * @date 2019/04/26
 * @author caiyf
 */
@RestController
@RequestMapping("/admin/order")
@Api(value = "admin-staff", description = "订单管理")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/all-order")
    public Result getAllOrder() {
        List<AllOrderResponse> responses = orderService.getAllOrder();
        return Result.getSuccessResult(responses);
    }

    @PostMapping("/my-order")
    public Result getMyOrder(@RequestHeader("num") Integer num) {
        List<MyOrderResponse> responses = orderService.getMyOrder(num);
        return Result.getSuccessResult(responses);
    }

    @PostMapping("/fdc")
    public Result fdc() {
        List<FdcResponse> responses = orderService.getFdcList();
        return Result.getSuccessResult(responses);
    }

    @PostMapping("/fp-order")
    public Result fpOrder(@RequestHeader("num") Integer num, @RequestBody FpOrderRequest request) {
        orderService.fpOrder(num, request);
        return Result.getSuccessResult(true);
    }

    @PostMapping("/start-order")
    public Result startOrder(@RequestBody FpOrderRequest request) {
        orderService.startOrder(request.getId());
        return  Result.getSuccessResult(true);
    }

    @PostMapping("/summary")
    public Result summary(@RequestBody OrderFeedback request) {
        orderService.summary(request);
        return Result.getSuccessResult(true);
    }

}
