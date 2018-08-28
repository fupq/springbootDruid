/**
 * 
 */
package com.fpq.druid.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.stat.DruidStatManagerFacade;

/**
 * @author slx
 *
 */
@RestController
public class DruidStatController {
	
	/**
	 * 在 Spring Boot 中如何通过 HTTP 接口将 Druid 监控数据以 JSON 的形式暴露出去
	 * @return
	 */
    @GetMapping("/durid/stat")
    public Object druidStat(){
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
}
