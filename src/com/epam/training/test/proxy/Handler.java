package com.epam.training.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public class Handler implements InvocationHandler{
    private Object target;

    public Handler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Hello from proxy");
        return method.invoke(target, args);
    }
}
