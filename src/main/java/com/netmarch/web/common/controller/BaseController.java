package com.netmarch.web.common.controller;

import com.alibaba.fastjson.JSONArray;
import com.netmarch.web.app.bean.AppResponse;
import com.netmarch.web.bean.JsonResult;
import com.netmarch.web.bean.ResultCodes;
import com.netmarch.web.common.utils.IpUtil;
import com.netmarch.web.common.utils.SpringUtils;
import com.netmarch.web.system.bean.Dict;
import com.netmarch.web.system.bean.LoginUser;
import com.netmarch.web.system.bean.StaticObj;
import com.netmarch.web.system.service.DictService;
import com.netmarch.web.system.service.LogService;
import com.netmarch.web.system.service.impl.DictServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller基类
 * @Author:wangdk
 * @Date:2019/2/14
 */

public abstract class BaseController {



    public static List<Dict> dictAll = null;

    public static AppResponse appResponse = null;


    @Autowired
    public LogService logService;


    //第一次初始化字典数据
    static {
        appResponse = new AppResponse();
    }

    /**
     * 日志写入方法
     * @param model 操作模块
     * @param action 操作路径
     * @param content 操作内容
     */
    protected  void log(String model,String action,String content){
        logService.save("操作用户",getIp(),model,action,content);
    }

    //获取当前Ip
    protected String getIp(){
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
       return IpUtil.GET_IP(request).equals("0:0:0:0:0:0:0:1")?"127.0.0.1":IpUtil.GET_IP(request);
    }

    protected JsonResult successResult(String message) {
        return new JsonResult(ResultCodes.SUCCESS, message);
    }

    protected JsonResult successResult(String message, String nextUrl) {
        return new JsonResult(ResultCodes.SUCCESS, message, nextUrl);
    }

    protected JsonResult successResult(String message, Object data) {
        return new JsonResult(ResultCodes.SUCCESS, message, data);
    }

    protected JsonResult errorResult(String message) {
        return new JsonResult(ResultCodes.ERROR, message);
    }
    protected JsonResult errorResult(String message, String nextUrl) {
        return new JsonResult(ResultCodes.ERROR, message, nextUrl);
    }

    /**
     * 校验用户是否存在session中
     * @param session
     * @return
     */
    protected boolean CHECK_USER_SESSION(HttpSession session){
        LoginUser users = (LoginUser) session.getAttribute(StaticObj.SESSION_KEY);
        if(users == null){
            return false;
        }
        return true;
    }

    /**
     * 用户保存在session中
     * @param session
     * @param users
     */
    protected void SET_USER_SESSION(HttpSession session, LoginUser users){
        session.setAttribute(StaticObj.SESSION_KEY,users);
    }

    /**
     * 获取session中的用户信息
     * @param session
     * @return
     */
    protected LoginUser GET_USER_SESSION(HttpSession session){
        return (LoginUser) session.getAttribute(StaticObj.SESSION_KEY);
    }

    /**
     * 清空session中的用户信息
     * @param session
     */
    protected void REMOVE_USER_SESSION(HttpSession session){
        session.removeAttribute(StaticObj.SESSION_KEY);
    }


    /**
     * ROLE保存在session中
     * @param session
     * @param list
     */
    protected void SET_ROLE_SESSION(HttpSession session, List<Integer> list){
        session.setAttribute(StaticObj.SESSION_ROLE_KEY,list);
    }

    /**
     * 获取session中的ROLE信息
     * @param session
     * @return
     */
    protected List<Integer> GET_ROLE_SESSION(HttpSession session){
        return (List<Integer>) session.getAttribute(StaticObj.SESSION_ROLE_KEY);
    }

    /**
     * 清空session中的 ROLE信息
     * @param session
     */
    protected void REMOVE_ROLE_SESSION(HttpSession session){
        session.removeAttribute(StaticObj.SESSION_ROLE_KEY);
    }


    /**
     * 从新初始化字典数据
     */
    protected void INIT_DICT() {

        initDict();
    }

    /**
     * 字典数据获取方法
     * @param model 返回页面保存对象 页面取值使用 key
     * @param key 父节点类型多个使用,号隔开
     * @param type "JSON"格式 "OBJ" object类型
     */
    protected void PUBLIC_DICT(Model model, String key, String type){
        if(dictAll == null){
            initDict();
        }
        String [] strKeys = key.split(",");
        for(String keys:strKeys){
            List<Dict> newList = new ArrayList<>();
            newList = findChild(dictAll, keys,newList);
            if("JSON".equals(type))
                model.addAttribute(keys, JSONArray.toJSONString(newList));
            else
                model.addAttribute(keys,newList);
        }

    }

    /**
     * 获取字典方法
     * @param key 字典的编码
     * @return 一个集合对象
     */
    protected Object PUBLIC_DICT_APP(String key){
        if(dictAll == null){
            initDict();
        }
        List<Dict> newList = new ArrayList<>();
        newList = findChild(dictAll, key,newList);
        return JSONArray.parse(JSONArray.toJSONString(newList));
    }

    public static void initDict() {
        DictService dictService = SpringUtils.getBean(DictServiceImpl.class);
        dictAll = dictService.findAll();
    }

    public static List<Dict> findChild(List<Dict> allList ,String key,List<Dict> cList ){
        for (Dict obj : allList) {
                if (key.equals(obj.getParentCode())) {
                    findChild(allList, obj.getCode(), cList);
                    cList.add(obj);
            }
        }
        return cList;
    }



}
