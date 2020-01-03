package com.netmarch.web.bean;

/**
 * @ClassName JsonResult
 * @Description TODO
 * @Author wangdk
 * @Date 2019/2/1415:58
 * @Version 1.0
 **/
public class JsonResult {

    private int code;
    private String message;
    private String nextUrl;
    private Object data;


    public JsonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonResult(int code, String message,Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonResult(int code, String message, String nextUrl) {
        this.code = code;
        this.message = message;
        this.nextUrl = nextUrl;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
