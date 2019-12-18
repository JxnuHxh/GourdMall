package com.hlz.gourdmall.controller;

import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.enums.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Hxh
 * @date: 2019/12/17
 * @description:
 */
@Api(tags = "支付")
@RestController
@RequestMapping("/pay")
public class PayController {
    @ApiOperation("订单支付")
    @GetMapping("allCart")
    public Result selectCart(Double money) {
       String message="你需要支付"+money;
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, message);
    }
}
