package com.hlz.gourdmall.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hlz.gourdmall.mapper.AdminCategoryMapper;
import com.hlz.gourdmall.mapper.CategoryMapper;
import com.hlz.gourdmall.model.Category;
import com.hlz.gourdmall.util.Page2Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: Hxh
 * @date: 2019/11/30
 * @description:
 */
@Service
public class CategoryService {
   @Resource
    private AdminCategoryMapper adminCategory;
   @Resource
   private CategoryMapper categoryMapper;
    @Autowired
    private Page2Data page2Data;

    public Map<String, Object> selectAllCategory(int pageSize,int  pageNum){
        PageHelper.startPage(pageNum, pageSize);
        Page<Category> categories=adminCategory.selectAllCategory();
        Map<String, Object> data = page2Data.page2Data(categories);
        return data;
    }

    public int deleteByPrimaryKey(String cid){
        Category category=categoryMapper.selectByPrimaryKey(cid);
        if(category!=null) {
            return categoryMapper.deleteByPrimaryKey(cid);
        }
        return 0;
    }
    public int insert(Category c){
        Category category=categoryMapper.selectByPrimaryKey(c.getCid());
        if(category!=null) {
        return categoryMapper.insert(c);
        }
        return 0;
    }
    public int updateByPrimaryKey(Category c){
        return categoryMapper.updateByPrimaryKeySelective(c);
    }
    public Category selectById(String cid){
        return categoryMapper.selectByPrimaryKey(cid);
    }

}
