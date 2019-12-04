package com.hlz.gourdmall.controller.admin;

import com.hlz.gourdmall.model.Category;
import com.hlz.gourdmall.service.AdmincategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Hxh
 * @date: 2019/11/26
 * @description:
 */
@Controller
@RequestMapping("/admin")
@ResponseBody
public class AdminController {
    @Autowired
    private AdmincategoryService admincategoryService;

    @PostMapping("/selectAllCategory")
    public List<Category> selectAllCategory() {

        List<Category> list = admincategoryService.selectAllCategory();
        return list;
    }
    @PostMapping("/deleteCategory")
    public  int deleteCategoryById(){
        int result = admincategoryService.deleteByPrimaryKey();
        return result;
    }
    @PostMapping("/insertSelective")
    public  int insertSelective(){
    int result = admincategoryService.insertSelective();
    return result;
    }
    @PostMapping("/updateById")
    public int updateByid(){
        int result = admincategoryService.updateByPrimaryKeySelective();
        return result;
    }
}
