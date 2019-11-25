package com.hlz.gourdmall.controller;

import com.hlz.gourdmall.util.SendCheckCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

/**
 * @author: Davion
 * @date: 2019/11/16
 * @description:
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private SendCheckCode sendCheckCode;

    @GetMapping("/code")
    public String test(){
        return "test";
    }

    @PostMapping("/code")
    @ResponseBody
    public Map<String, String> checkCode(String sno, String sname) throws IOException {
        System.out.println(sno + sname);
        Map<String, String> result = sendCheckCode.sendCode(sno.trim(), sname.trim());
        return result;
    }
}
