package com.epam.training.test.proxy;

import com.epam.training.annotations.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
@Proxy(invocationHandler = Handler.class)
public class ProxyTest implements IProxyTest{
    private String name;

    public ProxyTest() {
        this.name = "NAME";
    }

    public ProxyTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void sayHello(){
        System.out.println("hello");
    }
}
