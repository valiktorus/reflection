package com.epam.training;

import com.epam.training.annotations.Proxy;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public class ProxyFactory {
    public static Object getInstanceOf(Class<?> clazz) {
        Proxy annotationProxy = clazz.getAnnotation(Proxy.class);
        if (annotationProxy != null) {
            try {
                return java.lang.reflect.Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), annotationProxy.invocationHandler().newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
