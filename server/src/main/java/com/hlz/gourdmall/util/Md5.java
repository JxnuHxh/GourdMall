package com.hlz.gourdmall.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @author: Davion
 * @date: 2019/11/26
 * @description: 密码md5加密工具类
 */
@Component
public class Md5 {

    // 从配置文件里取盐值
    @Value("${md5.key}")
    private String key;

    /**
     * 加密
     * @param password
     * @return
     */
    public String encrypt(String password){
        byte[] text = (password + key).getBytes();
        return DigestUtils.md5DigestAsHex(text);
    }

    /**
     * 验证
     * @param beforePassword
     * @param finalPassword
     * @return
     */
    public Boolean confirm(String beforePassword, String finalPassword){
        return encrypt(beforePassword).equals(finalPassword);
    }
}
