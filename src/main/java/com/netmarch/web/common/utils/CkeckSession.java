package com.netmarch.web.common.utils;

import com.netmarch.web.system.bean.LoginUser;
import com.netmarch.web.system.bean.StaticObj;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 操作session公共类
 */
public class CkeckSession {
    /**
     * 校验用户是否存在session中
     * @param session
     * @return
     */
    public static boolean CHECK_USER_SESSION(HttpSession session){
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
    public static void SET_USER_SESSION(HttpSession session, LoginUser users){
        session.setAttribute(StaticObj.SESSION_KEY,users);
    }

    /**
     * 获取session中的用户信息
     * @param session
     * @return
     */
    public static LoginUser GET_USER_SESSION(HttpSession session){
        return (LoginUser) session.getAttribute(StaticObj.SESSION_KEY);
    }

    /**
     * 清空session中的用户信息
     * @param session
     */
    public static void REMOVE_USER_SESSION(HttpSession session){
        session.removeAttribute(StaticObj.SESSION_KEY);
    }

    /**
     * ROLE保存在session中
     * @param session
     * @param list
     */
    public static void SET_ROLE_SESSION(HttpSession session, List<Integer> list){
        session.setAttribute(StaticObj.SESSION_ROLE_KEY,list);
    }

    /**
     * 获取session中的ROLE信息
     * @param session
     * @return
     */
    public static List<Integer> GET_ROLE_SESSION(HttpSession session){
        return (List<Integer>) session.getAttribute(StaticObj.SESSION_ROLE_KEY);
    }

    /**
     * 清空session中的 ROLE信息
     * @param session
     */
    public static void REMOVE_ROLE_SESSION(HttpSession session){
        session.removeAttribute(StaticObj.SESSION_ROLE_KEY);
    }

}
