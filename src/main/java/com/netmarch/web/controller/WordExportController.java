package com.netmarch.web.controller;

import com.netmarch.web.common.utils.ExportWord;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WordExportController {


    @RequestMapping(value = "wordExport", method = RequestMethod.GET)
    public void wordExport(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("a","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        map.put("b","bb滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答的b");
        map.put("c","ccc");
        map.put("d","ddd");
        map.put("e","eee");
        map.put("f","发发发");
        map.put("g","444");
        //图片转为base64字符串
        map.put("h",getImage2String(ResourceUtils.getFile("classpath:word/Koala.jpg")));
        ExportWord.createWord(map, "test.ftl", "test.doc", request, response);
    }

    /**
     * 图片输出流
     *
     * @return
     * @throws IOException
     */
    public String getImage2String(File file) throws IOException {
        InputStream in = null;
        String accp = "";
        byte[] data = null;
        try {
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encodeBuffer(data);
    }
}
