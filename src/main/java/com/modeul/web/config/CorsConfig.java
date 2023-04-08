package com.modeul.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // 맵핑 주소가 전체가 되게 해준다. # : 루트 / ## 아래아래
				.allowedOrigins("http://localhost:5173"); // url을 맞게 변경 해준다.
			}
		};
	}
}
