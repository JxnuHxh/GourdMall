package com.hlz.gourdmall.controller.admin;

import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.enums.ResultCode;
import com.hlz.gourdmall.model.Category;
import com.hlz.gourdmall.service.admin.CategoryService;
import okhttp3.CertificatePinner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * @author: Hxh
 * @date: 2019/12/4
 * @description:
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/listCategory")
    public Result selectAllCategory(@RequestParam(name = "pageSize", defaultValue = "1") int pageSize,
                                    @RequestParam(name = "pageNum", defaultValue = "10") int pageNum) {
        Map<String, Object> categories = categoryService.selectAllCategory(pageSize, pageNum);
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, categories);
    }

    @GetMapping("/deleteCategoryById")
    public  Result deleteByPrimaryKey(String  cid){
        int result = categoryService.deleteByPrimaryKey(cid);
        return new Result(ResultCode.CATEGORY_DELETE_SUCCESS, result);
    }
    @GetMapping("/addCategory")
    public Result addCategory(String cid,String cname ){
       Category category = null;
        category.setCid(cid);
        category.setCname(cname);
     Integer result=categoryService.insert(category);
        return  new Result(ResultCode.CATEGORY_ADD_SUCCESS,result);
    }
    @GetMapping("/updateCategory")
    public Result updateCategory(String cid, String cname){
        Category category = null;
        category.setCid(cid);
        category.setCname(cname);
        Integer result=categoryService.updateByPrimaryKey(category);
        return  new Result(ResultCode.CATEGORY_UPDATE_SUCCESS,result);
    }
    @GetMapping("/updateCategory")
    public Result selectById(String cid){
        Category category=categoryService.selectById(cid);
        return  new Result(ResultCode.CATEGORY_FIND_SUCCESS,category);
    }

}
