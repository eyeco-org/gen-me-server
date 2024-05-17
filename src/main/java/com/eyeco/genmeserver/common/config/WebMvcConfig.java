package com.eyeco.genmeserver.common.config;

import com.eyeco.genmeserver.common.logging.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	// filter에 포함되는 URL의 주소입니다.
	private static final String[] INCLUDE_PATHS = {

	};

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET", "POST", "PUT", "PATCH", "OPTIONS")
				.allowedHeaders("headers")
				.maxAge(3000);
	}
	@Bean
	public FilterRegistrationBean<LogFilter> filterBean() {
		FilterRegistrationBean<LogFilter> registrationBean = new FilterRegistrationBean<>(new LogFilter());
		// 필터 여러개 적용 시에는 순번이 있어야합니다.
		// LogFilter가 동작하는 URL을 설정해줘야합니다.
		registrationBean.setUrlPatterns(Arrays.asList(
			"/test/*", "/*"
		));

		return registrationBean;
	}
}
