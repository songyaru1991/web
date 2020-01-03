package com.netmarch.web.app.bean;

public enum CodeEnum {
    //正常
    APP_SUCCESS(10001),
    //错误
    APP_ERROR(10002),
    //系统异常错误
    APP_EXCEPTION(10003),
    //token过期
    APP_TOKEN_ERROR(10004),
    //用户登陆错误（用户名无效）
    APP_USERNAME_ERROR(10010),
    //用户登陆错误（密码错误）
    APP_PASSWORD_ERROR(10011);

    private int value;

    private CodeEnum(int value){
        this.value = value;
    }

    //手写的从int到enum的转换函数
    public static CodeEnum valueOf(int value) {
        switch (value) {
            case 10001:
                return APP_SUCCESS;
            case 10002:
                return APP_ERROR;
            case 10003:
                return APP_EXCEPTION;
            case 10004:
                return APP_TOKEN_ERROR;
            case 10010:
                return APP_USERNAME_ERROR;
            case 10011:
                return APP_PASSWORD_ERROR;
            default:
                return null;
        }
    }

    public int value() {
        return this.value;
    }
}
