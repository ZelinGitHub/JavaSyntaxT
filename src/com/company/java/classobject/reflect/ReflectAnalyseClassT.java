package com.company.java.classobject.reflect;

import java.lang.reflect.*;

/**
 * 利用反射分析类
 */
public class ReflectAnalyseClassT {


    public static String getClassInfo(String name) {
        StringBuilder info = new StringBuilder();

        try {
            Class clsCls = Class.forName(name);
            info.append(getModifiers(clsCls))
                    .append(getParentClsName(clsCls))
                    .append(getFieldsInfo(clsCls))
                    .append(getConstructorsInfo(clsCls))
                    .append(getMethodsInfo(clsCls));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return info.toString();
    }

    /**
     * 输出目标类的所有修饰符
     */
    private static String getModifiers(Class clsCls) {
        return "类的所有修饰符" + Modifier.toString(clsCls.getModifiers());
    }

    /**
     * 输出目标类的父类
     */
    private static String getParentClsName(Class clsCls) {
        Class superClsCls = clsCls.getSuperclass();
        if (superClsCls != null) {
            return "父类名" + superClsCls.getName();
        } else {
            return "没有父类";
        }
    }

    /**
     * 输出目标类的所有字段的信息
     */
    private static String getFieldsInfo(Class clsCls) {
        Field[] fields = clsCls.getDeclaredFields();

        StringBuilder info = new StringBuilder();
        for (Field field : fields) {
            info.append("字段修饰符：").append(Modifier.toString(field.getModifiers()))
                    .append("字段名：").append(field.getName())
                    .append("字段类型").append(field.getType());
        }
        return info.toString();
    }


    /**
     * 输出目标类的所有构造器的信息
     */
    private static String getConstructorsInfo(Class clsCls) {
        Constructor[] constructors = clsCls.getConstructors();
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

    /**
     * 输出目标类的所有成员方法的信息
     */
    private static String getMethodsInfo(Class clsCls) {
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
