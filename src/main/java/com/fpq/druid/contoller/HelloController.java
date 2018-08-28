package com.fpq.druid.contoller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableAutoConfiguration
public class HelloController {

	/**
	 * http://127.0.0.1:8080/hello2
	 * http://127.0.0.1:8108/myProject/hello2
	 * @return
	 */
	@RequestMapping("/hello2")
	public String hello2(){
		
		return "hello2";
	}
	
	@RequestMapping("/test2")
	public String test2(){
		int tes = 18/0;
		return "test2:测试异常，全局捕获异常,tes=" + tes;
	}
	
	//启动方式1
//	public static void main(String[] args){
//		SpringApplication.run(HelloController.class, args);
//	}
}
