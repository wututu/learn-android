package com.bsss.ioctest.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD )
//@Target({ ElementType.FIELD , ElementType.METHOD })
public @interface ViewInject {
	public int id();
	public String click() default "";
}
