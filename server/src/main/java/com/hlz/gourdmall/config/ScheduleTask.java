package com.hlz.gourdmall.config;

import com.hlz.gourdmall.mapper.CheckCodeMapper;
import com.hlz.gourdmall.mapper.TokenMapper;
import com.hlz.gourdmall.mapper.UserMapper;
import com.hlz.gourdmall.model.CheckCodeExample;
import com.hlz.gourdmall.model.TokenExample;
import com.hlz.gourdmall.model.User;
import com.hlz.gourdmall.model.UserExample;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: Davion
 * @date: 2019/11/26
 * @description: 定时任务
 */
@Configuration
@EnableScheduling
public class ScheduleTask {

    @Resource
    private UserMapper userMapper;

    @Resource
    private CheckCodeMapper checkCodeMapper;

    @Resource
    private TokenMapper tokenMapper;

    /**
     * 每个整点清理数据库过期临时数据
     */
    @Scheduled(cron = "0 0 */1 * * ?")
    public void clearInvalidData(){
        clearUser();
        clearCheckCode();
        clearToken();
    }

    /**
     * 获取过期时间
     * @return
     */
    private Date getLineTime(int type, int val){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(type, val);
        return calendar.getTime();
    }

    /**
     * 清理过期未激活用户
     */
    private void clearUser(){
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andStateEqualTo((short) 0)
                .andCreateTimeLessThan(getLineTime(Calendar.DATE, -7));
        userMapper.deleteByExample(userExample);
    }

    /**
     * 清理验证码
     */
    private void clearCheckCode(){
        CheckCodeExample codeExample = new CheckCodeExample();
        // 删除已使用过的验证码
        codeExample.createCriteria()
                .andStateEqualTo((short) 1);
        checkCodeMapper.deleteByExample(codeExample);
        // 删除已超时的验证码
        codeExample.createCriteria()
                .andCreateTimeLessThan(getLineTime(Calendar.MINUTE, -10));
        checkCodeMapper.deleteByExample(codeExample);
    }

    /**
     * 清理token
     */
    private void clearToken(){
        TokenExample tokenExample = new TokenExample();
        tokenExample.createCriteria()
                .andCreateTimeLessThan(getLineTime(Calendar.DATE, -15));
        tokenMapper.deleteByExample(tokenExample);
    }
}
