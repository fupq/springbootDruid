package com.fpq.druid.contoller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
* <p>Title:GlobalExceptionHandler 拦截异常 </p>
* <p>Description: </p>
* @author xn042142 付品欣
* @date 2017年11月7日 下午2:16:27
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Map<String,Object> exceptionHandler(){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("code","500");
		result.put("msg","亲，系统错误，请稍后在试...");
		return result;
	}
}
