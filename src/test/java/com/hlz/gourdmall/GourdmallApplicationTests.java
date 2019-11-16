package com.hlz.gourdmall;

import com.hlz.gourdmall.util.SendCheckCode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class GourdmallApplicationTests {

    @Test
    void contextLoads() throws IOException {
        String result = new SendCheckCode().sendCode("201726705020", "刘勇");
    }

}
