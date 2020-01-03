package com.netmarch.web.system.mapper;

import com.github.pagehelper.Page;
import com.netmarch.web.common.mybatis.MyBaseMapper;
import com.netmarch.web.system.bean.Log;
import com.netmarch.web.system.model.LogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @ClassName LogMapper
 * @Description TODO
 * @Author wangdk
 * @Date 2019/2/1414:21
 * @Version 1.0
 **/
@Mapper
public interface LogMapper extends MyBaseMapper<Log> {

    /**
     * 条件查询日志列表
     * @param logQuery
     *
     * @return Page<Log>
     */
    Page<Log> listLog(LogQuery logQuery);

    /**
     * 保存日志内容
     * @param
     *
     */
    void save(@Param("userName") String userName, @Param("ip") String ip, @Param("model") String model, @Param("action") String action, @Param("content") String content, @Param("createTime") Date createTime);


}
