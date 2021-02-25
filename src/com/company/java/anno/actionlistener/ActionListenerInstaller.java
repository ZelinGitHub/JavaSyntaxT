package com.company.java.anno.actionlistener;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ActionListenerInstaller {


    public static void processAnnotations(Object obj) {
        try {
            //得到目标对象的类的Class，目标对象是一个Activity
            Class<?> cls = obj.getClass();
            //遍历Class的所有Method
            for (Method method : cls.getDeclaredMethods()) {
                //得到指定方法上的注解实例
                //拥有ActionListenerFor注解的Method是点击回调
                ActionListenerFor actionListenerFor = method.getAnnotation(ActionListenerFor.class);
                if (actionListenerFor != null) {
                    //调用注解的方法
                    //得到注解的参数值
                    //元素值是一个控件的名字
                    String source = actionListenerFor.source();
                    //得到指定的域
                    Field field = cls.getDeclaredField(source);
                    //设置这个域可访问
                    field.setAccessible(true);
                    //得到这个域在当前对象上的值，这个值是个控件
                    Object fieldValue = field.get(obj);
                    //为控件设置监听
                    addListener(fieldValue, obj, method);
                }
            }
        } catch (ReflectiveOperationException pE) {
            pE.printStackTrace();
        }
    }

    public static void addListener(Object source, final Object param, Method m) {
        //实现InvocationHandler
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object pO, Method pMethod, Object[] pObjects) throws Throwable {
                return pMethod.invoke(param);
            }
        };
    }
}
