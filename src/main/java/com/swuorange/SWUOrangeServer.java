package com.swuorange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan
public class SWUOrangeServer extends  SpringBootServletInitializer {
/*jar包启动*/
	public static void main(String[] args) {
		SpringApplication.run(SWUOrangeServer.class, args);
	}
/*war包启动*/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SWUOrangeServer.class);
	}
	
}
