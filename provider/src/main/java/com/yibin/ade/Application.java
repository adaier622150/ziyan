package com.yibin.ade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
@ServletComponentScan
@SpringBootApplication
@MapperScan("com.yibin.ade.service.dao")
@ComponentScan(basePackages = {"com.yibin.ade.*"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
