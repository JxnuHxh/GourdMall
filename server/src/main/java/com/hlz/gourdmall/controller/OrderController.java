package com.hlz.gourdmall.controller;


import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.enums.ResultCode;
import com.hlz.gourdmall.model.*;
import com.hlz.gourdmall.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: Hxh
 * @date: 2019/12/9
 * @description:
 */
@Api(tags = "订单接口")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @ApiOperation("提交订单")
    @GetMapping("/saveOrder")
    public  Result aboutOrder(List<OrderItem> orderItems, String telephone,String name,String address,Long uid){
        Order order=orderService.aboutOrder(orderItems,telephone,name,address,uid);
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, order);
    }

    @ApiOperation("查询当前用户下所有订单")
    @GetMapping("/listOrder")
    public Result selectAllCategory(@RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                                                  Integer uid) {

        Map<String, Object> orders = orderService.selectAllOrder(pageSize, pageNum, uid);
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, orders);
    }
    @ApiOperation("根据订单ID查询订单")
    @GetMapping("/{id}")
    public Result getOrderById(@PathVariable(name = "id") String id) {
        Map<String, Object> data = orderService.getOrderById(id);
        return new Result(ResultCode.PRODUCT_FIND_SUCCESS, data);
    }
    @ApiOperation("更新订单")
    @PutMapping("/updateOrder")
    public  Result updateOrder(Order order){
        Integer data=orderService.updateOrder(order);
        return new Result(ResultCode.PRODUCT_FIND_SUCCESS, data);
    }

    @ApiOperation("删除订单")
    @DeleteMapping("/deleteOrder")
    public  Result deleteOrder(String id){
        Integer data=orderService.deleteOrder(id);
        return new Result(ResultCode.PRODUCT_FIND_SUCCESS, data);
    }
    @ApiOperation("后台查询所有订单")
    @GetMapping("/allOrder")
    public  Result allOrder(@RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                            @RequestParam(name = "pageNum", defaultValue = "1") int pageNum
                            ){
        Map<String, Object> orders = orderService.allOrder(pageSize, pageNum);
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, orders);
    }
}
