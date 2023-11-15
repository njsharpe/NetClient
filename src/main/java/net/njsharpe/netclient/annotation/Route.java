package net.njsharpe.netclient.annotation;

import net.njsharpe.netclient.http.Verb;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Route {

    String uri();
    Verb verb();

}
