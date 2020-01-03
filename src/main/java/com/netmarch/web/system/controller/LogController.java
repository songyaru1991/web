package com.netmarch.web.system.controller;

import com.github.pagehelper.Page;

import com.netmarch.web.bean.Login;
import com.netmarch.web.common.controller.BaseController;
import com.netmarch.web.common.utils.DateUtil;
import com.netmarch.web.system.bean.Log;
import com.netmarch.web.system.model.LogQuery;
import com.netmarch.web.system.service.LogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Login
@RequestMapping(value = "log")
@Controller
public class LogController extends BaseController {


    @Autowired
    public LogService logService;

    @GetMapping("list")
    public ModelAndView list(LogQuery logQuery){

        log("操作日志","获取操作日志信息列表","查询列表");

        if(StringUtils.isEmpty(logQuery.getStartTime())){
            logQuery.setStartTime(DateUtil.getDate("yyyy-MM-dd") + " 00:00:00");
        }
        if(StringUtils.isEmpty(logQuery.getEndTime())){
            logQuery.setEndTime(DateUtil.getDate("yyyy-MM-dd") + " 23:59:59");
        }

        ModelAndView mv = new ModelAndView("system/log/list");
        Page<Log> list = logService.listLog(logQuery);
        mv.addObject("list",list);
        mv.addObject("logQuery",logQuery);

        return  mv;
    }
}
