package com.netmarch.web.system.service;

import com.github.pagehelper.Page;
import com.netmarch.web.system.bean.Log;
import com.netmarch.web.system.model.LogQuery;
import org.springframework.stereotype.Service;


/**
 * @ClassName LogService
 * @Description 日志管理接口
 * @Author wangdk
 * @Date 2019/2/1414:44
 * @Version 1.0
 **/
@Service
public interface LogService {

    /**
     * 条件查询日志
     * @param logQuery
     *
     * @return Page<Log>
     */
    Page<Log> listLog(LogQuery logQuery);

    /**
     * 保存日志
     * @param userName,ip,model,action,content
     *
     */
    void save(String userName, String ip, String model, String action, String content);

}
