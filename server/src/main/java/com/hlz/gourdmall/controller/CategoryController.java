package com.hlz.gourdmall.controller;

import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.enums.ResultCode;
import com.hlz.gourdmall.model.Category;
import com.hlz.gourdmall.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: Hxh
 * @date: 2019/12/4
 * @description:
 */
@Api(tags = "分类接口")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation("查询所有分类")
    @GetMapping("/listCategory")
    public Result selectAllCategory(@RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "pageNum", defaultValue = "1") int pageNum) {
        Map<String, Object> categories = categoryService.selectAllCategory(pageSize, pageNum);
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, categories);
    }


    @ApiOperation("根据id删除分类")
    @GetMapping("/deleteCategoryById")
    public Result deleteByPrimaryKey(String cid) {
        int result = categoryService.deleteByPrimaryKey(cid);
        return new Result(ResultCode.CATEGORY_DELETE_SUCCESS, result);
    }
    @ApiOperation("增加分类")
    @PostMapping("/addCategory")
    public Result addCategory(Category category) {
        Integer result = categoryService.insert(category);
        return new Result(ResultCode.CATEGORY_ADD_SUCCESS, result);
    }
    @ApiOperation("更新分类")
    @PutMapping("/updateCategory")
    public Result updateCategory(Category category) {
        Integer result = categoryService.updateByPrimaryKey(category);
        return new Result(ResultCode.CATEGORY_UPDATE_SUCCESS, result);
    }

    @ApiOperation("根据ID查找分类")
    @GetMapping("/selectCategory")
    public Result selectById(String cid) {
        Category category = categoryService.selectById(cid);
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, category);
    }
}
