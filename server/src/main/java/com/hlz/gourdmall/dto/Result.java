package com.hlz.gourdmall.dto;

import com.hlz.gourdmall.enums.ResultCode;
import lombok.Data;
import java.io.Serializable;

/**
 * @author: Davion
 * @date: 2019/11/25
 * @description: 
 */
@Data
public class Result implements Serializable {
    private Integer code;
    private String message;
    private Object data;

    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
}
