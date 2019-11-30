package com.hlz.gourdmall.controller.admin;

import com.hlz.gourdmall.model.Category;
import com.hlz.gourdmall.service.AdmincategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class AdminController {
    @Autowired
   private AdmincategoryService admincategoryService;
    @PostMapping("/selectAllCategory")
    public  List<Category> selectAllCategory(){

        List<Category> list =admincategoryService.selectAllCategory();



        return list;
    }


}
