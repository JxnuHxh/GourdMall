package com.hlz.gourdmall.controller;

import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.enums.ResultCode;
import com.hlz.gourdmall.service.CategoryService;
import com.hlz.gourdmall.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("查询所有订单")
    @GetMapping("/listOrder")
    public Result selectAllCategory(@RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "pageNum", defaultValue = "1") int pageNum) {
        Map<String, Object> orders = orderService.selectAllOrder(pageSize, pageNum);
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, orders);
    }
    @ApiOperation("根据ID查询订单")
    @GetMapping("/{}")
    public Result getOrderById(@PathVariable(name = "id") String id) {
        Map<String, Object> data = orderService.getOrderById(id);
        return new Result(ResultCode.PRODUCT_FIND_SUCCESS, data);
    }


}
