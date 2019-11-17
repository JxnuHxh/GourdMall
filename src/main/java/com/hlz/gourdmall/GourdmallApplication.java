package com.hlz.gourdmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hlz.gourdmall.mapper")
public class GourdmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(GourdmallApplication.class, args);
    }

}
