package com.epam.training;

import com.epam.training.annotations.Proxy;
import com.epam.training.exception.ProxyException;

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
        Proxy annotationProxy = clazz.getAnnotation(Proxy.class);
        if (annotationProxy != null) {
            try {
                return java.lang.reflect.Proxy.newProxyInstance(clazz.getClassLoader(),
                        clazz.getInterfaces(),
                        annotationProxy.invocationHandler()
                                .getConstructor(Object.class).newInstance(clazz.newInstance()));
            } catch (InstantiationException | IllegalAccessException
                    | NoSuchMethodException | InvocationTargetException e) {
                throw new ProxyException(e);
            }
        }
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ProxyException(e);
        }
    }
}
