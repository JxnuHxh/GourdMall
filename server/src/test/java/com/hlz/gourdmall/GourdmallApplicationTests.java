package com.hlz.gourdmall;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hlz.gourdmall.mapper.UserExtMapper;
import com.hlz.gourdmall.mapper.UserMapper;
import com.hlz.gourdmall.model.User;
import com.hlz.gourdmall.util.Md5;
import com.hlz.gourdmall.util.SendCheckCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@SpringBootTest
class GourdmallApplicationTests {

    @Resource
    private UserExtMapper userExtMapper;


    @Test
    void contextLoads() throws IOException {
        PageHelper.startPage(2, 5);
        Page<User> users = userExtMapper.listUser();
        System.out.println(users);
    }

}
