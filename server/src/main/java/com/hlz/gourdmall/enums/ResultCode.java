package com.hlz.gourdmall.enums;

/**
 * @author: Davion
 * @date: 2019/11/25
 * @description:
 */
public enum ResultCode {
    // 返回结果状态集
    SEND_CODE_SUCCESS(2000, "验证码发送成功"),
    SEND_ERROR(5000, "验证码发送失败"),
    SNO_ALREADY_EXIST(5001, "学号已注册"),
    CONFIRM_SUCCESS(2100, "验证码正确"),
    CONFIRM_FAIL(4100, "验证码错误"),
    SNO_NO_MARCH(4101, "学号不匹配"),
    USER_NOT_EXIST(4400, "用户不存在"),
    PASSWORD_SET_SUCCESS(2200, "密码设置成功"),
    PASSWORD_SET_FAIL(4200, "密码设置失败"),
    LOGIN_SUCCESS(2300, "登录成功"),
    LOGIN_FAIL(4300, "登录失败"),
    LIST_USER_SUCCESS(2500, "获取用户列表成功"),
    LIST_USER_FAIL(4600, "获取用户列表失败"),
    PRODUCT_FIND_SUCCESS(2400, "商品查询成功"),
    PRODUCT_FIND_FAIL(4500, "商品查询失败"),
    CATEGORY_FIND_SUCCESS(2600, "分类查询成功"),
    CATEGORY_FIND_FAIL(4601, "分类查询失败"),
    CATEGORY_ADD_SUCCESS(2601,"增加分类成功"),
    CATEGORY_ADD_FAIL(4601,"增加分类失败"),
    CATEGORY_DELETE_FAIL(4602,"删除分类失败"),
    CATEGORY_DELETE_SUCCESS(2602,"删除分类成功"),
    CATEGORY_UPDATE_SUCCESS(2603,"修改分类成功"),
    CATEGORY_UPDATE_(4603,"修改分类失败")
    ;

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
