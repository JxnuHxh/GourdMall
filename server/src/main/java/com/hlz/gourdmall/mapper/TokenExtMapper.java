package com.hlz.gourdmall.mapper;

import com.github.pagehelper.Page;
import com.hlz.gourdmall.model.Category;
import org.apache.ibatis.annotations.Select;

/**
 * @author: Hxh
 * @date: 2019/12/15
 * @description:
 */
public interface TokenExtMapper {
    @Select("select uid from token where token=#{token}")
   Long  selectUid(String token);
}
