package com.epam.training.test.proxy;

import com.epam.training.ProxyFactory;
import com.epam.training.exception.ProxyException;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public class RunProxy {
    public static void main(String[] args) {
        try {
            IProxyTest proxyTest = (IProxyTest) ProxyFactory.getInstanceOf(ProxyTest.class);
            proxyTest.sayHello();
        } catch (ProxyException e) {
            System.err.println(e.getMessage());
        }

    }
}
