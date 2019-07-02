package com.swuorange.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.swuorange.interceptor.RSAIntercepter;

@Configuration
public class RSAIntercepterConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RSAIntercepter()).addPathPatterns("/user/login");
	}
}
