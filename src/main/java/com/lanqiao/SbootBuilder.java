package com.lanqiao;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * 工程组建类
 * 
 * @author  
 * @version  [版本号, 2017年12月21日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@SpringBootApplication
//扫描包，使类中的注解组建生效
@ComponentScan(value = {"com.lanqiao"})  
public class SbootBuilder {

}