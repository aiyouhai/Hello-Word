package com.tt.springboottest.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.tt.springboottest.converter.DateConverter;
import com.tt.springboottest.converter.StringOrderToListConverter;

@Configuration
@EnableWebMvc
@ComponentScan
public class CorsConfig extends WebMvcConfigurerAdapter {
	static final String ORIGINS[] = new String[] { "GET", "POST", "PUT", "DELETE" };

	/**
	 * 实现跨域的操作 registry.addMapping("/**")//设置允许跨域的路径
	 * .allowedOrigins("*")//设置允许跨域请求的域名 .allowCredentials(true)//是否允许证书 不再默认开启
	 * .allowedMethods("POST")//设置允许的方法"GET", "POST", "PUT", "DELETE"
	 * .maxAge(3600);//跨域允许时间
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods(ORIGINS).maxAge(3600);
	}

	/**
	 * 注册 拦截器
	 */
//	@Override
	// public void addInterceptors(InterceptorRegistry registry) {
	// registry.addInterceptor(new SecurityHandlerInterceptor())
	// 添加过滤url ** 代表所有
	//// .addPathPatterns("/**")
	// 添加排除过滤url
	// .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**",
	// "/swagger-ui.html/**",
	// "/register", "/login", "/**/error");
	// super.addInterceptors(registry);
	// }

	// 解决中文乱码问题

	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));

		return converter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(responseBodyConverter());
		converters.add(new MappingJackson2HttpMessageConverter());
	}

	/**
	 * 解决resources下面静态资源无法访问
	 * 
	 * @param registry
	 */

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 添加静态资源路径
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
		super.addResourceHandlers(registry);
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		super.addFormatters(registry);
		registry.addConverter(new DateConverter());
		registry.addConverter(new StringOrderToListConverter());

	}
}
