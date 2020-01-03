package com.netmarch.web.common.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class ExportWord {

    /**
     *
     * @param dataMap       数据源map
     * @param templateName  模版名称xxx.ftl
     * @param fileName      导出word的文件名xxx.doc
     * @param request
     * @param response
     */
    public static void createWord(Map dataMap, String templateName, String fileName, HttpServletRequest request, HttpServletResponse
            response) {
        try {
            //创建配置实例
            Configuration configuration = new Configuration();

            //设置编码
            configuration.setDefaultEncoding("UTF-8");

            //ftl模板文件统一放至项目 dcmbFile文件夹下面
            configuration.setClassForTemplateLoading(ExportWord.class,"/word");

            //导出并下载word
            response.setContentType("application/msword");

            response.setHeader("content-disposition",
                    "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO-8859-1"));

            response.setCharacterEncoding("utf-8");//此句非常关键,不然word文档全是乱码

            PrintWriter out = response.getWriter();

            Template t = configuration.getTemplate(templateName, "utf-8");//以utf-8的编码读取ftl文件

            t.process(dataMap, out);

            //关闭流
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

