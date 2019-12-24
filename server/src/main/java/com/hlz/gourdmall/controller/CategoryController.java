package com.hlz.gourdmall.controller;

import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.enums.ResultCode;
import com.hlz.gourdmall.model.Category;
import com.hlz.gourdmall.service.CategoryService;
import com.hlz.gourdmall.service.ProductService;
import com.hlz.gourdmall.util.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    private ProductService productService;


    @ApiOperation("查询所有分类")
    @GetMapping("/listCategory")
    public Result selectAllCategory() {
         List<Category>  categoryList=(List<Category>)redisTemplate.opsForValue().get("categoryList");
         if(categoryList==null){
             categoryList= categoryService.selectAllCategory();
             redisTemplate.opsForValue().set("categoryList",categoryList);
         }
         return new Result(ResultCode.CATEGORY_FIND_SUCCESS, categoryList);
    }

    @ApiOperation("根据分类查询商品")
    @GetMapping("/productBycid")
    public Result selectProduct(@RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                @RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                                @RequestParam(name = "cid") String cid) {
        Map<String, Object> products = categoryService.selectProduct(pageSize, pageNum, cid);
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, products);
    }

    @ApiOperation("删除分类")
    @DeleteMapping("/deleteCategoryById")
    public Result deleteByPrimaryKey(String cid) {

        List<Category> categoryList= categoryService.selectAllCategory();
        int count =productService.selectProduct(cid);
        if(count>0){
            return new Result(ResultCode.CATEGORY_DELETE_FAIL, null);
        }
        int result = categoryService.deleteByPrimaryKey(cid);
        if(result==0){
            redisTemplate.opsForValue().set("categoryList",categoryList);
            return new Result(ResultCode.CATEGORY_UPDATE_F, null);
        }
        redisTemplate.opsForValue().set("categoryList",categoryList);

        return new Result(ResultCode.CATEGORY_DELETE_SUCCESS, result);
    }

    @ApiOperation("增加分类")
    @PostMapping("/addCategory")
    public Result addCategory(Category category) {
        Integer result = categoryService.insert(category);
        List<Category> categoryList= categoryService.selectAllCategory();
        redisTemplate.opsForValue().set("categoryList",categoryList);
        if(result==0){
            return new Result(ResultCode.CATEGORY_ADD_FAIL, null);
        }
        return new Result(ResultCode.CATEGORY_ADD_SUCCESS, result);
    }

    @ApiOperation("修改分类")
    @PutMapping("/updateCategory")
    public Result updateCategory(Category category) {
        Integer result = categoryService.updateByPrimaryKey(category);
        List<Category> categoryList= categoryService.selectAllCategory();
        redisTemplate.opsForValue().set("categoryList",categoryList);
        if(result==0){
            return new Result(ResultCode.CATEGORY_UPDATE_, null);
        }
        return new Result(ResultCode.CATEGORY_UPDATE_SUCCESS, result);
    }

    @ApiOperation("根据ID查找分类")
    @GetMapping("/selectCategory")
    public Result selectById(String cid) {
        Category category = categoryService.selectById(cid);
        if(category==null){
            return new Result(ResultCode.CATEGORY_FIND_FAIL, null);
        }
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, category);
    }

    @ApiOperation("根据分类名查询分类")
    @GetMapping("/selectCategoryByName")
    public Result selectByName(String cname) {
        Category category = categoryService.selectByCname(cname);
        if(category==null){
            return new Result(ResultCode.CATEGORY_FIND_FAIL, null);
        }
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, category);
    }
}