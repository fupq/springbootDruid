/**
 * 自定义事务
 */
package com.fpq.druid.config;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.transaction.annotation.EnableTransactionManagement;  
  
import javax.annotation.Resource;  
import javax.sql.DataSource; 

/**
 * @author fpq
 *自定义事务
 */
@Configuration  
@EnableTransactionManagement  
@Slf4j
public class DataSourceTransactionManager {

	private static Logger logger = LoggerFactory.getLogger(DataSourceTransactionManager.class);
	
	 /** 
      * 自定义事务 
     * MyBatis自动参与到spring事务管理中，无需额外配置，只要org.mybatis.spring.SqlSessionFactoryBean引用的数据源与DataSourceTransactionManager引用的数据源一致即可，否则事务管理会不起作用。 
     * @return 
     */  
    @Resource(name = "writeDataSource")  
    private DataSource dataSource;  
    @Bean(name = "transactionManager")  
    public org.springframework.jdbc.datasource.DataSourceTransactionManager transactionManagers() {  
        logger.info("-------------------- transactionManager init ---------------------");  
        return new org.springframework.jdbc.datasource.DataSourceTransactionManager(dataSource);  
    }  
}
