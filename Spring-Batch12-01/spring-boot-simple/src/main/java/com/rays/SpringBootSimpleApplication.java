package com.rays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSimpleApplication {

//	@Autowired
//	private FrontCtl frontCtl;

	public static void main(String[] args) {

		SpringApplication.run(SpringBootSimpleApplication.class, args);

	}

//	@Bean
//	public WebMvcConfigurer webConfig() {
//		return new WebMvcConfigurer() {
//
//			@Override
//			public void addInterceptors(InterceptorRegistry registry) {
//				registry.addInterceptor(frontCtl).addPathPatterns("/**").excludePathPatterns("/Auth/**");
//			}
//		};
//	}

}
