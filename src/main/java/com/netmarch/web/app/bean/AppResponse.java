package com.netmarch.web.app.bean;

/**
 * APP 返回对象类
 */
public class AppResponse {

    public String desc ;//返回消息
    public int status;//返回状态
    public Object result;//返回对象


    //成功操作返回
    public AppResponse SUCCESS(){
        this.desc = MsgEnum.操作成功.toString();
        this.status = CodeEnum.APP_SUCCESS.value();
        this.result = null;
        return this;
    }

    public AppResponse SUCCESS(String desc){
        this.desc = desc;
        this.status = CodeEnum.APP_SUCCESS.value();
        this.result = null;
        return this;
    }

    public AppResponse SUCCESS(String desc,Object result){
        this.desc = desc;
        this.status = CodeEnum.APP_SUCCESS.value();
        this.result = result;
        return this;
    }

    public AppResponse SUCCESS(int status,String desc,Object result){
        this.desc = desc;
        this.status = status;
        this.result = result;
        return this;
    }

    //失败操作返回
    public AppResponse ERROR(){
        this.desc = MsgEnum.操作失败.toString();
        this.status = CodeEnum.APP_ERROR.value();
        this.result = null;
        return this;
    }

    public AppResponse ERROR(String desc){
        this.desc = desc;
        this.status = CodeEnum.APP_ERROR.value();
        this.result = null;
        return this;
    }

    public AppResponse ERROR(String desc,Object result){
        this.desc = desc;
        this.status = CodeEnum.APP_ERROR.value();
        this.result = result;
        return this;
    }

    public AppResponse ERROR(int status,String desc,Object result){
        this.desc = desc;
        this.status = status;
        this.result = result;
        return this;
    }

}
