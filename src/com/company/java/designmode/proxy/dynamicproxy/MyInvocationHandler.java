package com.company.java.designmode.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private final Object mObject;

    public MyInvocationHandler(Object pObject) {
        mObject = pObject;
    }

    @Override
    public Object invoke(Object pO, Method pMethod, Object[] pObjects) throws Throwable {
        return pMethod.invoke(mObject,pObjects);
    }
}
