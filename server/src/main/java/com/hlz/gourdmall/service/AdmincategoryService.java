package com.hlz.gourdmall.service;

import com.hlz.gourdmall.mapper.AdminCategoryMapper;
import com.hlz.gourdmall.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Hxh
 * @date: 2019/11/30
 * @description:
 */
@Service
public class AdmincategoryService {
    @Autowired
    private AdminCategoryMapper adminCategory;
    public List<Category> selectAllCategory(){
        List<Category> list= adminCategory.selectAllCategory();
        return list;
    }

}
