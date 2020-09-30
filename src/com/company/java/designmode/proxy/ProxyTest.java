package com.company.java.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void test() {
        Girl girl = new Girl();
        ClassLoader classLoader = Girl.class.getClassLoader();
        InvocationHandler invocationHandler = new MyInvocationHandler(girl);
        Object proxy = Proxy.newProxyInstance(
                classLoader
                , new Class[]{
                        AssSubject.class
                        , ChestSubject.class
                        , PussySubject.class
                }
                , invocationHandler
        );
        AssSubject assProxy = (AssSubject) proxy;
        ChestSubject chestProxy = (ChestSubject) proxy;
        PussySubject pussyProxy = (PussySubject) proxy;
        assProxy.lick();
        chestProxy.grab();
        pussyProxy.insert();

        Class proxyClass=Proxy.getProxyClass(
                classLoader
                , AssSubject.class
                , ChestSubject.class
                , PussySubject.class
        );

        Integer integer=123;
        InvocationHandler handler=new MyInvocationHandler(integer);
        Object proxyX=Proxy.newProxyInstance(
                null
                ,new Class[]{
                        Comparable.class
                }
                ,handler
        );

    }
}
