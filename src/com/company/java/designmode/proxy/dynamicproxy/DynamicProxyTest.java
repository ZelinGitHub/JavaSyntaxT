package com.company.java.designmode.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public void fuck() {
        //创建本人
        Girl girl = new Girl();
        //得到ClassLoader
        ClassLoader classLoader = Girl.class.getClassLoader();
        //创建InvocationHandler
        InvocationHandler invocationHandler = new MyInvocationHandler(girl);
        //定义代理类并创建代理类的实例
        //参数1传入被代理类的ClassLoader
        //参数2传入代理接口的Class数组
        //参数3传入InvocationHandler
        Object proxy = Proxy.newProxyInstance(
                classLoader
                , new Class[]{
                        AssSubject.class
                        , ChestSubject.class
                        , PussySubject.class
                }
                , invocationHandler
        );
        //转换为指定的代理接口类型
        AssSubject assProxy = (AssSubject) proxy;
        ChestSubject chestProxy = (ChestSubject) proxy;
        PussySubject pussyProxy = (PussySubject) proxy;
        //调用代理方法
        //InvocationHandler的invoke方法都会被调用，并向其传递Method对象和原始的调用参数
        assProxy.lick();
        chestProxy.grab();
        pussyProxy.insert();
    }

    public void fly(){
        ClassLoader classLoader = Girl.class.getClassLoader();
        Class proxyClass = Proxy.getProxyClass(
                classLoader
                , AssSubject.class
                , ChestSubject.class
                , PussySubject.class
        );
    }

    public void fight() {
        //被代理实例
        Integer integer = 123;
        InvocationHandler handler = new MyInvocationHandler(integer);
        //创建代理类实例
        //参数1传null，使用默认的ClassLoader
        //参数2传代理接口的Class数组
        //参数3传InvocationHandler
        Object proxyX = Proxy.newProxyInstance(
                null
                , new Class[]{
                        Comparable.class
                }
                , handler
        );
    }

    public static void test() {
        DynamicProxyTest test = new DynamicProxyTest();
        test.fuck();
    }
}
