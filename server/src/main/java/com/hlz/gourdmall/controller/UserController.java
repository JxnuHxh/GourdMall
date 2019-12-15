package com.hlz.gourdmall.controller;

import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.enums.ResultCode;
import com.hlz.gourdmall.model.User;
import com.hlz.gourdmall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Davion
 * @date: 2019/11/23
 * @description: 用户控制层
 */
@Api(tags = "用户接口")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("发送验证码")
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

    @ApiOperation("确认验证码")
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

    @ApiOperation("设置密码")
    @PostMapping("/setPassword")
    public Result setPassword(String studentNo, String password) {
        User dbUser = userService.findUserBySno(studentNo);
        if (dbUser == null) {
            return new Result(ResultCode.USER_NOT_EXIST, null);
        }
        userService.setPassword(dbUser, password);
        return new Result(ResultCode.PASSWORD_SET_SUCCESS, null);
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login(String studentNo, String password,HttpServletRequest request) {
        User dbUser = userService.findUserBySno(studentNo);
        if (dbUser == null) {
            return new Result(ResultCode.USER_NOT_EXIST, null);
        }
        Boolean loginFlag = userService.login(dbUser, password);
        Result result;
        if (loginFlag) {
            String token = userService.setToken(dbUser.getUid());
            Map<String, String> tokenData = new HashMap<>();
            request.getSession().setAttribute("loginUser", dbUser);
            tokenData.put("token", token);
            result = new Result(ResultCode.LOGIN_SUCCESS, tokenData);
        } else {
            result = new Result(ResultCode.LOGIN_FAIL, null);
        }
        return result;
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/listUser")
    public Result listUser(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        Map<String, Object> users = userService.listUser(pageNum, pageSize);
        return new Result(ResultCode.LIST_USER_SUCCESS, users);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/user/{id}")
    public Result deleteUserById(@PathVariable(name = "id") long id) {
        boolean ans = userService.deleteUserById(id);
        return new Result(ResultCode.SEND_CODE_SUCCESS, ans);
    }
}
