package com.hlz.gourdmall.mapper;

import com.github.pagehelper.Page;
import com.hlz.gourdmall.model.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author: Davion
 * @date: 2019/12/3
 * @description:
 */
public interface UserExtMapper {

    @Select("select * from user")
    Page<User> listUser();

}
