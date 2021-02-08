package org.wc.tools.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by WenChen on 2020/11/25.
 */
public class log4j2Test {

    private static final Logger logger = LoggerFactory.getLogger(log4j2Test.class);

    private static final Logger busi = LoggerFactory.getLogger("busi");

    @Test
    public void consoleLogTest(){
        logger.info("这是一条测试");
        logger.warn("这是第二条测试");
        logger.error("这是第三条测试");
    }

    @Test
    public void busiLogTest(){
        busi.info("这是第一条busi测试");
        busi.warn("这是第二条busi测试");
        busi.error("这是第三条busi测试");
    }
}
