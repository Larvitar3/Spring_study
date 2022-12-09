package com.tencoding.blog.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tencoding.blog.interceptor.AuthUserInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MycCidng implements WebMvcConfigurer{

	
	private final AuthUserInterceptor authUserInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authUserInterceptor);
	}
	
	
	
	
}
