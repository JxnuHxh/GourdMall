package com.hlz.gourdmall.mapper;

import com.github.pagehelper.Page;
import com.hlz.gourdmall.model.Product;
import org.apache.ibatis.annotations.Select;

/**
 * @author: Davion
 * @date: 2019/12/3
 * @description:
 */
public interface ProductExtMapper {

    @Select("select * from product")
    Page<Product> listProduct();

}
