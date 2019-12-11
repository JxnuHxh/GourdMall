package com.hlz.gourdmall.controller.admin;

import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.enums.ResultCode;
import com.hlz.gourdmall.service.ProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: Hxh
 * @date: 2019/12/9
 * @description:
 */
//@RestController
//@RequestMapping("/admin")
//public class IndexController {
//    @Autowired
//    private ProductServer productServer;
//    @GetMapping
//    public Result index(@RequestParam(name = "pageSize", defaultValue = "1") int pageSize,
//                        @RequestParam(name = "pageNum", defaultValue = "10") int pageNum){
//        Map<String, Object> products = productServer.listProduct(pageSize, pageNum);
//        return new Result(ResultCode.PRODUCT_FIND_SUCCESS, products);
//
//    }
//}
