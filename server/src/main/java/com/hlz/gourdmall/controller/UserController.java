package com.hlz.gourdmall.controller;

import com.hlz.gourdmall.mapper.CheckCodeMapper;
import com.hlz.gourdmall.mapper.UserMapper;
import com.hlz.gourdmall.model.CheckCode;
import com.hlz.gourdmall.model.User;
import com.hlz.gourdmall.model.UserExample;
import com.hlz.gourdmall.util.SendCheckCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Davion
 * @date: 2019/11/23
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SendCheckCode sendCheckCode;

    @Resource
    private UserMapper userMapper;

    @Resource
    private CheckCodeMapper checkCodeMapper;

    @PostMapping("/sendCheckCode")
    public String sendCheckCode(String sno, String sname) throws IOException {
        // 查询该学号是否已注册
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andSnoEqualTo(sno);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0) {

        } else {
            // 不存在，发送验证码并插入数据库
            Map<String, String> codeResult = sendCheckCode.sendCode(sno, sname);
            if ("success".equals(codeResult.get("msg"))) {
                // 插入用户表
                User newUser = new User();
                newUser.setSno(sno);
                newUser.setNickname(sname);
                newUser.setState((short) 0);
                newUser.setAdmin((short) 0);
                newUser.setCreateTime(new Date());
                userMapper.insert(newUser);

                // 验证码表
                List<User> dbUser = userMapper.selectByExample(userExample);
                CheckCode checkCode = new CheckCode();
                checkCode.setCode(codeResult.get("code"));
                checkCode.setUid(dbUser.get(0).getUid());
                checkCode.setCreateTime(new Date());
                checkCode.setState((short) 0);
                checkCodeMapper.insert(checkCode);
            }
        }

        return "yes";
    }

}
