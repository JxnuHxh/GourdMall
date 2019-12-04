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
public interface AdminCategoryMapper {
    @Select("select * from category")
    Page<Product> selectAllCategory();

}
