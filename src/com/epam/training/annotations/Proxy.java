package com.epam.training.annotations;

import com.epam.training.handlers.DefaultInvocationHandler;

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
    /**
     * Invocation handler class.
     *
     * @return the class of InvocationHandler impementation
     */
    Class<? extends InvocationHandler> invocationHandler() default DefaultInvocationHandler.class;
}
