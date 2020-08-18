
package com.tt.springboottest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.tt.springboottest.ui.dao")
@EnableCaching // 开启缓存
@EnableScheduling
@EnableAsync // 开启异步执行（就是开启多线程的意思）
@EnableAutoConfiguration
@EnableTransactionManagement
public class SpringBootTestApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApp.class, args);
	}
}
