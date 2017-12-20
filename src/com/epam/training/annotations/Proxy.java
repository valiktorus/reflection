package com.epam.training.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;

/**
 * Created by Valiantsin Pshanichnik on 19.12.2017.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface Proxy {
    Class<? extends InvocationHandler> invocationHandler();
}
