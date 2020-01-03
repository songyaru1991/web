package com.netmarch.web.common.mybatis;
import org.apache.ibatis.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * mybatis日志打印输出
 */
public class MyBatisLogs implements Log {

    private final static Logger logger = LoggerFactory.getLogger(MyBatisLogs.class);

    public MyBatisLogs(String clazz) {
        // Do Nothing
    }
    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void error(String s, Throwable e) {

    }

    @Override
    public void error(String s) {

        System.out.println("ERROR" +s);

    }

    @Override
    public void debug(String s) {
        logger.info("操作信息："+s);
    }

    @Override
    public void trace(String s) {
        //System.out.println("TRACE" +s);
    }

    @Override
    public void warn(String s) {
        System.out.println("WARN" +s);
    }
}