package com.hlz.gourdmall;

import com.hlz.gourdmall.util.Md5;
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

    @Autowired
    private Md5 md5;

    @Test
    void contextLoads() throws IOException {
        String password = md5.encrypt("666666");
        System.out.println(password);
        System.out.println(md5.confirm("666666", "a20907f82b02def31500e48b05d47170"));
    }

}
