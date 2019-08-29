package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@SpringBootApplication
public class App {
	
	@Bean
	public HttpMessageConverters fastJsonConfigure(){
	    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
	    FastJsonConfig fastJsonConfig = new FastJsonConfig();
	    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
	    //日期格式化
	    fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
	    converter.setFastJsonConfig(fastJsonConfig);
	    return new HttpMessageConverters(converter);
	}
//d
	 
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("start");
	}
}
