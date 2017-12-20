package com.epam.training.handlers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Valiantsin Pshanichnik on 21.12.2017.
 *
 * @param <T> the type parameter
 */
public class DefaultInvocationHandler<T> implements InvocationHandler {
    private T target;

    /**
     * Instantiates a new Default invocation handler.
     *
     * @param target the target
     */
    public DefaultInvocationHandler(final T target) {
        this.target = target;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        System.out.printf("method %s invoked from proxy\n", method.getName());
        return method.invoke(target, args);
    }
}
