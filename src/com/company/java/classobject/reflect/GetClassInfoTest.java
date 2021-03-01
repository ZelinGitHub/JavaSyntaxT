package com.company.java.classobject.reflect;

import java.lang.reflect.*;


public class GetClassInfoTest {

    public void test(String name) {
        StringBuilder info = new StringBuilder();

        try {
            Class clsCls = Class.forName(name);
            info.append(getModifiers(clsCls))
                    .append(getParentClsName(clsCls))
                    .append(getFields(clsCls))
                    .append(getConstructors(clsCls))
                    .append(getMethods(clsCls));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(info.toString());
    }


    private String getModifiers(Class cls) {
        return "类的所有修饰符" + Modifier.toString(cls.getModifiers());
    }


    private String getParentClsName(Class cls) {
        Class superClsCls = cls.getSuperclass();
        if (superClsCls != null) {
            return "父类名" + superClsCls.getName();
        } else {
            return "没有父类";
        }
    }

    private String getFields(Class cls) {
        Field[] fields = cls.getDeclaredFields();

        StringBuilder info = new StringBuilder();
        for (Field field : fields) {
            info.append("字段修饰符：").append(Modifier.toString(field.getModifiers()))
                    .append("字段名：").append(field.getName())
                    .append("字段类型").append(field.getType());
        }
        return info.toString();
    }


    private String getConstructors(Class cls) {
        Constructor[] constructors = cls.getConstructors();
        StringBuilder info = new StringBuilder();
        for (Constructor constructor : constructors) {
            info.append("构造器名：").append(constructor.getName())
                    .append("构造器修饰符：").append(Modifier.toString(constructor.getModifiers()));


            Class[] paramClsClses = constructor.getParameterTypes();
            for (Class paramClsCls : paramClsClses) {
                info.append("构造器参数类型：").append(paramClsCls.getName());
            }
        }

        return info.toString();
    }


    private String getMethods(Class clsCls) {
        Method[] methods = clsCls.getMethods();

        StringBuilder info = new StringBuilder();
        for (Method method : methods) {
            Class returnValueClsCls = method.getReturnType();
            info.append("方法返回值类型：").append(returnValueClsCls)
                    .append("方法名：").append(method.getName())
                    .append("方法修饰符：").append(Modifier.toString(method.getModifiers()));


            Class[] paramClsClses = method.getParameterTypes();
            for (Class paramClass : paramClsClses) {
                info.append("方法形参类型：").append(paramClass.getName());
            }
        }
        return info.toString();
    }

}
