package com.hlz.gourdmall.controller;

import com.github.pagehelper.Page;
import com.hlz.gourdmall.enums.ResultCode;
import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.model.User;
import com.hlz.gourdmall.service.UserService;
import com.hlz.gourdmall.util.Page2Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Davion
 * @date: 2019/11/23
 * @description: 用户控制层
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 发送验证码
     *
     * @param studentNo
     * @param studentName
     * @return
     * @throws IOException
     */
    @GetMapping("/sendCheckCode")
    public Result sendCheckCode(String studentNo, String studentName) throws IOException {
        User dbUser = userService.findUserBySno(studentNo);
        // 该学号用户存在并已激活
        if (dbUser != null && dbUser.getState() == 1) {
            return new Result(ResultCode.SNO_ALREADY_EXIST, null);
        }
        // 数据库无该学号，创建
        if (dbUser == null) {
            userService.insertUser(studentNo, studentName);
            dbUser = userService.findUserBySno(studentNo);
        }
        String code = userService.sendCode(studentNo, studentName);
        if (code == null) {
            return new Result(ResultCode.SEND_ERROR, null);
        }
        // 验证码写入数据库
        userService.insertCode(dbUser.getUid(), code);
        Map<String, String> data = new HashMap<>();
        data.put("code", code);
        return new Result(ResultCode.SEND_CODE_SUCCESS, data);
    }

    /**
     * 确认验证码
     *
     * @param studentNo
     * @param checkCode
     * @return
     */
    @PostMapping("/confirmCheckCode")
    public Result confirmCheckCode(String studentNo, String checkCode) {
        User dbUser = userService.findUserBySno(studentNo);
        if (dbUser == null) {
            return new Result(ResultCode.SNO_NO_MARCH, null);
        }
        // 验证码判断
        Boolean confirm = userService.confirmCode(dbUser.getUid(), checkCode);
        Result result;
        if (confirm) {
            result = new Result(ResultCode.CONFIRM_SUCCESS, null);
        } else {
            result = new Result(ResultCode.CONFIRM_FAIL, null);
        }
        return result;
    }

    /**
     * 设置密码
     *
     * @param studentNo
     * @param password
     * @return
     */
    @PostMapping("/setPassword")
    public Result setPassword(String studentNo, String password) {
        User dbUser = userService.findUserBySno(studentNo);
        if (dbUser == null) {
            return new Result(ResultCode.USER_NOT_EXIST, null);
        }
        userService.setPassword(dbUser, password);
        return new Result(ResultCode.PASSWORD_SET_SUCCESS, null);
    }

    /**
     * 登录
     *
     * @param studentNo
     * @param password
     * @return
     */
    @PostMapping("/login")
    public Result login(String studentNo, String password, HttpServletRequest request) {
        User dbUser = userService.findUserBySno(studentNo);
        if (dbUser == null) {
            return new Result(ResultCode.USER_NOT_EXIST, null);
        }
        Boolean loginFlag = userService.login(dbUser, password);
        Result result;
        if (loginFlag) {
            String token = userService.setToken(dbUser.getUid());
            Map<String, String> tokenData = new HashMap<>();
            tokenData.put("token", token);
            result = new Result(ResultCode.LOGIN_SUCCESS, tokenData);
        } else {
            result = new Result(ResultCode.LOGIN_FAIL, null);
        }
        return result;
    }

    @Autowired
    private Page2Data page2Data;

    @GetMapping("/listUser")
    public Result listUser(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        Page<User> users = userService.listUser(pageNum, pageSize);
        Map<String, Object> data = page2Data.page2Data(users);
        System.out.println(users);
        return new Result(ResultCode.LIST_USER_SUCCESS, data);
    }
}
