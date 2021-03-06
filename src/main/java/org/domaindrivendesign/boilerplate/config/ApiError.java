package org.domaindrivendesign.boilerplate.config;

import org.domaindrivendesign.boilerplate.core.exception.ErrorCode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ApiError {
    ErrorCode[] codes() default {};
}
