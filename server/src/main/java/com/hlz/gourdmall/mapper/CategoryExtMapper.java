package com.hlz.gourdmall.mapper;

import com.github.pagehelper.Page;
import com.hlz.gourdmall.model.Category;
import com.hlz.gourdmall.model.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Hxh
 * @date: 2019/11/30
 * @description:
 */
public interface CategoryExtMapper {
    @Select("select * from category")
    Page<Category> selectAllCategory();
    @Select("select * from category where cname=#{cname}")
    Category selectCategoryByName(String cname);
    @Select("select * from product where cid=#{cid}")
    Page<Product> selectProduct(String cid);
}
