/**
 * 
 */
package com.fpq.druid.config;

import lombok.extern.slf4j.Slf4j;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component; 

/**
 * @author fpq
 *
 */
@Aspect  
@Component  
@Slf4j  
public class DataSourceAop {

	private static Logger logger = LoggerFactory.getLogger(DataSourceAop.class);
	
	@Before("execution(* com.fpq.druid.mapper..*.select*(..)) || execution(* com.fpq.druid.mapper..*.get*(..))")  
    public void setReadDataSourceType() {  
        DataSourceContextHolder.read();  
        logger.info("dataSource切换到：Read");  
    }  
  
    @Before("execution(* com.fpq.druid.mapper..*.insert*(..)) || execution(* com.fpq.druid.mapper..*.update*(..))")  
    public void setWriteDataSourceType() {  
        DataSourceContextHolder.write();  
        logger.info("dataSource切换到：write");  
    }  
}
