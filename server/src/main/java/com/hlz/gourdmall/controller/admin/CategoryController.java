package com.hlz.gourdmall.controller.admin;

import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.enums.ResultCode;
import com.hlz.gourdmall.model.Category;
import com.hlz.gourdmall.service.admin.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: Hxh
 * @date: 2019/12/4
 * @description:
 */
@RestController
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public Result selectAllCategory(@RequestParam(name = "pageSize", defaultValue = "1") int pageSize,
                                    @RequestParam(name = "pageNum", defaultValue = "10") int pageNum) {
        Map<String, Object> categories = categoryService.selectAllCategory(pageSize, pageNum);
        return new Result(ResultCode.PRODUCT_FIND_SUCCESS, categories);

    }
}
