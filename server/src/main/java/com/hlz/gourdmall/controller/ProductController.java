package com.hlz.gourdmall.controller;

import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.enums.ResultCode;
import com.hlz.gourdmall.model.Product;
import com.hlz.gourdmall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: Davion
 * @date: 2019/12/9
 * @description:
 */
@Api(tags = "商品接口")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productServer;

    @ApiOperation("获取商品列表")
    @GetMapping("")
    public Result listProduct(@RequestParam(name = "pageSize", defaultValue = "1") int pageSize,
                              @RequestParam(name = "pageNum", defaultValue = "10") int pageNum) {
        Map<String, Object> products = productServer.listProduct(pageSize, pageNum);
        return new Result(ResultCode.PRODUCT_FIND_SUCCESS, products);
    }

    // 根据id查找商品

    @ApiOperation("根据id查找商品")
    @GetMapping("/{id}")
    public Result getProductById(@PathVariable(name = "id") String id) {
        Map<String, Object> data = productServer.getProductById(id);
        return new Result(ResultCode.PRODUCT_FIND_SUCCESS, data);
    }

    @ApiOperation("添加商品")
    @PostMapping("")
    public Result postProduct(Product product) {
        boolean ans = productServer.insert(product);
        return new Result(ResultCode.PRODUCT_INSTALL_SUCCESS, null);
    }

    @ApiOperation("删除商品")
    @DeleteMapping("/{id}")
    public Result deleteProductById(@PathVariable(name = "id") String id) {
        boolean ans = productServer.deleteProductById(id);
        return new Result(ResultCode.PRODUCT_DELETE_SUCCESS, null);
    }

    @ApiOperation("更新商品")
    @PutMapping("")
    public Result updateProduct(Product product) {
        boolean ans = productServer.update(product);
        return new Result(ResultCode.PRODUCT_UPDATE_SUCCESS, null);
    }
}
