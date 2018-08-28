/**
 * 
 */
package com.fpq.druid.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import lombok.extern.slf4j.Slf4j;  
/**
 * @author fpq
 *  数据库配置：解析properties文件 
 */
@Slf4j  
@Configuration 
//@PropertySource("classpath:/mybatis.properties")  //将properties配置文件中的值存储到Spring的 Environment中，Environment接口提供方法去读取配置文件中的值，参数是properties文件中定义的key值。
public class DataBaseConfiguration {

	private  final Logger logger = LoggerFactory.getLogger(DataBaseConfiguration.class);
	
	@Value("${spring.datasource.type}")  
    private Class<? extends DataSource> dataSourceType;  
  
    @Bean(name="writeDataSource", destroyMethod = "close", initMethod="init")  
    @Primary  
    @ConfigurationProperties(prefix = "spring.datasource")  
    public DataSource writeDataSource() {  
        logger.info("-------------------- writeDataSource init ---------------------");  
        return DataSourceBuilder.create().type(dataSourceType).build();  
    }  
    /** 
       * 有多少个从库就要配置多少个 
     * @return 
     */  
    @Bean(name = "readDataSource1")  
    @ConfigurationProperties(prefix = "spring.slave")  
    public DataSource readDataSourceOne(){  
        logger.info("-------------------- readDataSourceOne init ---------------------");  
        return DataSourceBuilder.create().type(dataSourceType).build();  
    }  
    
    @Bean("readDataSources")  
    public List<DataSource> readDataSources(){  
        List<DataSource> dataSources=new ArrayList<>();  
        dataSources.add(readDataSourceOne());  
        //dataSources.add(readDataSourceTwo());  
        return dataSources;  
    }  
}
