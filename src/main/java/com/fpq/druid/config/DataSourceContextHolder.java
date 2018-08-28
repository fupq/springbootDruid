/**
 * 本地线程全局变量
 */
package com.fpq.druid.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author fpq
 *
 */
@Slf4j
public class DataSourceContextHolder {

	private  final static Logger logger = LoggerFactory.getLogger(DataSourceContextHolder.class);
	
	private static final ThreadLocal<String> local = new ThreadLocal<String>();  
	  
    public static ThreadLocal<String> getLocal() {  
        return local;  
    }  
  
    /** 
     * 读可能是多个库 
     */  
    public static void read() {  
  
        local.set(DataSourceType.read.getType());  
    }  
  
    /** 
     * 写只有一个库 
     */  
    public static void write() {  
        logger.debug("writewritewrite");  
        local.set(DataSourceType.write.getType());  
    }  
  
    public static String getJdbcType() {  
        return local.get();  
    }  
}
