package com.company.anno.actionlistener;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ActionListenerInstaller {
    public static void processAnnotations(Object obj){
        try{
            Class<?> cls=obj.getClass();
            for(Method method:cls.getDeclaredMethods()){
                //得到指定方法上的注解对象
                ActionListenerFor actionListenerFor=method.getAnnotation(ActionListenerFor.class);
                if(actionListenerFor!=null){
                    //得到注解的元素值
                    String source=actionListenerFor.source();
                    //得到指定的域
                    Field field=cls.getDeclaredField(source);
                    field.setAccessible(true);
                    //得到这个域在当前对象上的值，这个值应该是个View
                    Object fieldValue=field.get(obj);
                    //为View设置监听
                    addListener(fieldValue,obj,method);
                }
            }
        }catch (ReflectiveOperationException pE){
            pE.printStackTrace();
        }
    }

    public static void addListener(Object source,final Object param,Method m){
        InvocationHandler handler=new InvocationHandler() {
            @Override
            public Object invoke(Object pO, Method pMethod, Object[] pObjects) throws Throwable {
                return m.invoke(param);
            }
        };

    }
}
