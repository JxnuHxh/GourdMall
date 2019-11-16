package com.hlz.gourdmall;

import com.hlz.gourdmall.util.SendCheckCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Map;

@SpringBootTest
class GourdmallApplicationTests {

    @Autowired
    private SendCheckCode sendCheckCode;

    @Test
    void contextLoads() throws IOException {
        Map<String, String> result = sendCheckCode.sendCode("201726705020", "刘勇");
        String code = result.get("code");
        System.out.println(code);
    }

}
