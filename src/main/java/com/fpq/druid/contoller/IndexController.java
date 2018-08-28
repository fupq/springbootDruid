package com.fpq.druid.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


/** 
* <p>Title:IndexController 测试使用FreeMarker 实现动态页面静态化</p>
* <p>Description: </p>
* @author xn042142 付品欣
* @date 2017年11月7日 下午2:54:05 
*/
@Controller
public class IndexController {

	/**index:跳转到ftl页面
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author xn042142 付品欣
	 * @param map
	 * @return 
	 * @since JDK 1.8
	 * 2017年11月7日 下午2:53:51
	 */  
	@RequestMapping("/index")
	public String index(ModelMap map){
		map.addAttribute("name", "付品欣");
		map.addAttribute("sex", 1);//0:女，1：男，2：其他
		List<String> userList = new ArrayList<String>();
		userList.add("张三");
		userList.add("李四");
		userList.add("王五");
		userList.add("鬼脚七");
		map.addAttribute("userList", userList);
		return "index";
	}
}
