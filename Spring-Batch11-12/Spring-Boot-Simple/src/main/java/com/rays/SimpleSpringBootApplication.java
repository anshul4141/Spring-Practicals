package com.rays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleSpringBootApplication {

//	@Autowired
//	private FrontCtl frontCtl;

	public static void main(String[] args) {

		SpringApplication.run(SimpleSpringBootApplication.class, args);

		System.out.println("Spring Applicatoin Started Successfully");

	}

//	@Bean
//	public WebMvcConfigurer webConfig() {
//
//		return new WebMvcConfigurer() {
//			@Override
//			public void addInterceptors(InterceptorRegistry registry) {
//				registry.addInterceptor(frontCtl).addPathPatterns("/**").excludePathPatterns("/Auth/*");
//			}
//		};
//
//	}

}
