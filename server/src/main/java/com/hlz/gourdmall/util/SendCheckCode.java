package com.hlz.gourdmall.util;

import okhttp3.Headers;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * @author: Davion
 * @date: 2019/11/16
 * @description: 发送验证码工具类
 */
@Component
public class SendCheckCode {
    /**
     * 生成验证码
     * @return　验证码
     */
    private String getCode(){
        char[] buffer = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        Random random = new Random();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append(buffer[random.nextInt(62)]);
        }
        return stringBuffer.toString();
    }


    @Value("${jxnu.__EVENTVALIDATION}")
    private String __EVENTVALIDATION;

    @Value("${jxnu.__VIEWSTATE}")
    private String __VIEWSTATE;

    @Value("${jxnu.Cookie}")
    private String cookie;
    /**
     * 发送验证码
     * @param sno 发送学号
     * @param sname 发送姓名
     * @return 发送结果
     * @throws IOException
     */
    public Map<String, String> sendCode(String sno, String sname) throws IOException {
        String receive = sno + "|" + sname + ",";
        OkHttpClientUtil clientUtil = OkHttpClientUtil.getInstance();
        String code = getCode();
        String url = "https://jwc.jxnu.edu.cn/User/Default.aspx?uctl=MyControl%2fMail_Write.ascx&Action=Mail_Write";
        Headers headers = new Headers.Builder()
                .add("Cookie", cookie)
                .build();
        Map<String, String> data = new HashMap<>();
        data.put("__EVENTVALIDATION", __EVENTVALIDATION);
        data.put("__VIEWSTATE", __VIEWSTATE);
        data.put("_ctl1:txtTitle", "注册激活短信");
        data.put("_ctl1:btnSend", "发送短信");
        data.put("_ctl1:txtReceiveUser", receive);
        data.put("ctl1_txtContent", code);
        Response response = clientUtil.postData(url, data, headers);
        String html = Objects.requireNonNull(response.body()).string();
        Map<String, String> result = new HashMap<>();
        result.put("code", code);
        if (html.contains("发送成功")) {
            result.put("msg", "success");
            return result;
        }
        result.put("msg", "fail");
        return result;
    }
}
