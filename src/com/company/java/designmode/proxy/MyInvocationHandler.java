package com.company.java.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object mObject;

    public MyInvocationHandler(Object pObject) {
        mObject = pObject;
    }

    @Override
    public Object invoke(Object pO, Method pMethod, Object[] pObjects) throws Throwable {
        return pMethod.invoke(mObject,pObjects);
    }
}
