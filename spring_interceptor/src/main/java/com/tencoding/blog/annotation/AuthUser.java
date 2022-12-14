package com.tencoding.blog.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 유지되는 기간 지정하는데 사용
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AuthUser {

	
	
}
