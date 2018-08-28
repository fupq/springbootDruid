package com.fpq.druid.contoller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/** 
* <p>Title:TestController </p>
* <p>Description: springBoot测试</p>
* @author xn042142 付品欣
* @date 2017年11月7日 上午11:20:42 
*/
@RestController
//@EnableAutoConfiguration
public class TestController {

	/**
	 * hello: springBoot测试类<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author xn042142 付品欣
	 * @return 
	 * @since JDK 1.8
	 */
	@RequestMapping("/hello")
	public String hello(){
		return "hi 付品欣！";
	}
	
	@RequestMapping("/getFile")
	public String getFile(){
		return "springBoot 测试";
	}
	
	//启动方式1
//	public static void main(String[] args){
//		SpringApplication.run(TestController.class, args);
//	}
	
}
