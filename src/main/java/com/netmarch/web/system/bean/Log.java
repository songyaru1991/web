package com.netmarch.web.system.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Log implements Serializable {

    /**
     * 主键id
     */
    public Integer id;

    /**
     * 用户
     */
    public String userName;

    /**
     * IP地址
     */
    public String ip;

    /**
     * 操作模块
     */
    public String model;

    /**
     * 操作
     */
    public String action;


    /**
     * 操作内容
     */
    public String content;


    /**
     * 操作时间
     */
    public Date createTime;

}
