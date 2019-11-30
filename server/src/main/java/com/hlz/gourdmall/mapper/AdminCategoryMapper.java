package com.hlz.gourdmall.mapper;

import com.hlz.gourdmall.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Hxh
 * @date: 2019/11/30
 * @description:
 */
@Repository
public interface AdminCategoryMapper {
    List<Category> selectAllCategory();
    int deleteCategoryById();
    int updateCategoryById();
}
