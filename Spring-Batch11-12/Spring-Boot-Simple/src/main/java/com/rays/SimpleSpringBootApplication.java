package com.rays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rays.common.FrontCtl;

@SpringBootApplication
public class SimpleSpringBootApplication {

	@Autowired
	private FrontCtl frontCtl;

	public static void main(String[] args) {

		SpringApplication.run(SimpleSpringBootApplication.class, args);

		System.out.println("Spring Applicatoin Started Successfully");

	}

	@Bean
	public WebMvcConfigurer webConfig() {

		return new WebMvcConfigurer() {
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(frontCtl).addPathPatterns("/**").excludePathPatterns("/Auth/*");
			}
		};

	}

}
