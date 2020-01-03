package com.netmarch.web.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class InterUtils {
    /**
     * 返回弹出框
     * @param request
     * @param response
     * @param msg
     * @throws Exception
     */
    public static void returnAlert(HttpServletRequest request, HttpServletResponse response, String msg) throws Exception{
        response.setContentType("text/html; charset=UTF-8"); //转码
        PrintWriter out = response.getWriter();
        out.flush();
        out.println("<script type='text/javascript' src='"+request.getContextPath()+"/js/jquery.min.js'></script>");
        out.println("<script src='"+request.getContextPath()+"/js/layui/layui.js'></script>");
        out.println("<script>");

        String strJs ="$(function(){"
                + "layui.use('layer', function(){ var $ = layui.jquery, layer = layui.layer; "
                + "layer.alert('"+msg+"', {"
                + "	    skin: 'layui-layer-molv'"
                + "	    ,closeBtn: 0"
                + "	    ,anim: 2 "
                + "	  },"
                + "	function(){parent.location.href='"+request.getContextPath()+"/';});"
                + "});});"
                + "</script>";

        out.println(strJs);
    }
}
