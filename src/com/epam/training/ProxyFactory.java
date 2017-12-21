package com.epam.training;

import com.epam.training.annotations.Proxy;
import com.epam.training.exception.ProxyException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public final class ProxyFactory {
    private ProxyFactory() {
    }

    /**
     * Gets instance of proxy class if Proxy annotation is defined
     * or instance of class.
     *
     * @param clazz the clazz
     * @return the instance of class or instance of proxy class
     * @throws ProxyException the proxy exception
     */
    public static Object getInstanceOf(final Class<?> clazz) throws ProxyException {
        try {
            return getInstance(clazz);
        } catch (IllegalAccessException | InstantiationException
                | NoSuchMethodException | InvocationTargetException e) {
            throw new ProxyException(e);
        }
    }

    private static Object getInstance(final Class<?> clazz) throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        Proxy annotationProxy = clazz.getAnnotation(Proxy.class);
        if (annotationProxy == null) {
            return clazz.newInstance();
        }
        final InvocationHandler handler = annotationProxy
                .invocationHandler()
                .getConstructor(Object.class)
                .newInstance(clazz.newInstance());
        return java.lang.reflect.Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(), handler);
    }
}
