package com.hlz.gourdmall.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hlz.gourdmall.mapper.CheckCodeMapper;
import com.hlz.gourdmall.mapper.TokenMapper;
import com.hlz.gourdmall.mapper.UserExtMapper;
import com.hlz.gourdmall.mapper.UserMapper;
import com.hlz.gourdmall.model.*;
import com.hlz.gourdmall.util.Md5;
import com.hlz.gourdmall.util.SendCheckCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Davion
 * @date: 2019/11/23
 * @description:
 */
@Service
public class UserService {

    @Autowired
    private SendCheckCode sendCheckCode;

    @Autowired
    private Md5 md5;

    @Resource
    private UserMapper userMapper;

    @Resource
    private CheckCodeMapper checkCodeMapper;

    @Resource
    private TokenMapper tokenMapper;

    @Resource
    private UserExtMapper userExtMapper;

    /**
     * 通过学号查找学生
     * @param studentNo
     * @return
     */
    public User findUserBySno(String studentNo) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andSnoEqualTo(studentNo);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    /**
     * 发送验证码
     * @param studentNo
     * @param studentName
     * @return
     * @throws IOException
     */
    public String sendCode(String studentNo, String studentName) throws IOException {
        Map<String, String> codeResult = sendCheckCode.sendCode(studentNo, studentName);
        if ("success".equals(codeResult.get("msg"))) {
            return codeResult.get("code");
        }
        return null;
    }

    /**
     * 插入新用户
     * @param studentNo
     * @param studentName
     * @return
     */
    public Integer insertUser(String studentNo, String studentName) {
        User newUser = new User();
        newUser.setSno(studentNo);
        newUser.setNickname(studentName);
        newUser.setCreateTime(new Date());
        newUser.setModifiedTime(newUser.getCreateTime());
        newUser.setAdmin((short) 0);
        newUser.setState((short) 0);
        return userMapper.insert(newUser);

    }

    /**
     * 插入验证码
     * @param uid
     * @param code
     */
    public void insertCode(Long uid, String code) {
        CheckCode checkCode = new CheckCode();
        checkCode.setUid(uid);
        checkCode.setCode(code);
        checkCode.setState((short) 0);
        checkCode.setCreateTime(new Date());
        checkCodeMapper.insert(checkCode);
    }

    /**
     * 确认验证码是否正确
     * @param uid
     * @param checkCode
     * @return
     */
    public Boolean confirmCode(Long uid, String checkCode) {
        // 查询出该uid用户发送的验证码
        CheckCodeExample codeExample = new CheckCodeExample();
        codeExample.createCriteria()
                .andUidEqualTo(uid);
        List<CheckCode> codes = checkCodeMapper.selectByExample(codeExample);
        if (codes.size() == 0) {
            return false;
        }
        // 逐个比对是否匹配
        Boolean flag = false;
        for (CheckCode code : codes) {
            if (code.getCode().equals(checkCode) && code.getState() == 0) {
                flag = true;
            }
        }
        // 比对成功将该用户发送的所有验证码状态标示为已使用，等待清楚
        if (flag) {
            codes.forEach(code -> {
                code.setState((short) 1);
                checkCodeMapper.updateByPrimaryKey(code);
            });
        }
        return flag;
    }

    /**
     * 设置密码
     * @param dbUser
     * @param password
     */
    public void setPassword(User dbUser, String password) {
        dbUser.setPassword(md5.encrypt(password));
        dbUser.setState((short) 1);
        dbUser.setModifiedTime(new Date());
        userMapper.updateByPrimaryKey(dbUser);
    }

    /**
     * 判断登录是否成功
     * @param dbUser
     * @param password
     * @return
     */
    public Boolean login(User dbUser, String password) {
        return md5.confirm(password, dbUser.getPassword());
    }

    public String setToken(Long uid) {
        String tokenStr = UUID.randomUUID().toString();
        Token record = new Token();
        record.setUid(uid);
        record.setToken(tokenStr);
        record.setCreateTime(new Date());
        tokenMapper.insert(record);
        return tokenStr;
    }

    public Page<User> listUser(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Page<User> users = userExtMapper.listUser();
        return users;
    }
}
