package com.netmarch.web.app.controller;

import com.netmarch.web.app.bean.AppResponse;
import com.netmarch.web.app.bean.CodeEnum;
import com.netmarch.web.app.bean.MsgEnum;
import com.netmarch.web.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AppController extends BaseController {

    //body取值方式
    //body-String类型的集合
    @RequestMapping("app/list")
    @ResponseBody
    public AppResponse applist(@RequestBody String body){
        //业务代码
        return appResponse.SUCCESS();
    }


    //param取值
    @RequestMapping("app/add")
    @ResponseBody
    public AppResponse appadd(@RequestParam("name") String name){
        //业务代码
        return appResponse.SUCCESS(CodeEnum.APP_PASSWORD_ERROR.value(), MsgEnum.上传图片失败.toString(),PUBLIC_DICT_APP("video_platform"));
    }

    //URL传值
    @RequestMapping("app/{id}")
    @ResponseBody
    public AppResponse app(@PathVariable("id") String id){
        //业务代码
        return appResponse.SUCCESS();
    }


}
