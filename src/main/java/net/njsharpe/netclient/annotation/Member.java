package net.njsharpe.netclient.annotation;

import net.njsharpe.netclient.http.Parameter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Member {

    boolean required() default false;
    Parameter parameter() default Parameter.QUERY;

}