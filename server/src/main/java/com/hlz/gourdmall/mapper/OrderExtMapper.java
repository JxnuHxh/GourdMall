package com.hlz.gourdmall.mapper;

import com.github.pagehelper.Page;
import com.hlz.gourdmall.model.Category;
import com.hlz.gourdmall.model.Order;
import org.apache.ibatis.annotations.Select;

/**
 * @author: Hxh
 * @date: 2019/12/11
 * @description:
 */
public  interface OrderExtMapper {
    @Select("select * from orders")
    Page<Order> selectAllOrder();

}
