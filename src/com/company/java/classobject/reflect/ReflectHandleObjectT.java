package com.company.java.classobject.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射分析对象
 */
public class ReflectHandleObjectT {

    /**
     * 操纵对象的字段值
     */
    public static void handleObjectFieldAll(Guy pGuy) {
        try {
            //创建类类对象，泛型是目标类类名
            Class<Guy> clsCls = Guy.class;
            //得到目标类所有字段
            Field[] fields = clsCls.getDeclaredFields();

            //设置字段可以访问，参数是数组，这是一个集体操作的快捷方法
            AccessibleObject.setAccessible(fields, true);
            //遍历字段
            for (Field field : fields) {
                if (field.getName().equals("id")) {
                    //设置对象字段值
                    field.set(pGuy, 213);
                    //得到对象字段值
                    Object idValue = field.get(pGuy);
                }
                if (field.getName().equals("name")) {
                    field.set(pGuy, "沙比");
                    Object nameValue = field.get(pGuy);
                }
            }

        } catch (IllegalAccessException ignored) {

        }
    }

    public static void handleObjectFieldOne(Guy pGuy) {
        try {
            //创建类类对象，参数是目标类类名
            Class<Guy> clsCls = Guy.class;
            //得到目标类指定名字的字段
            Field id = clsCls.getDeclaredField("id");
            //设置目标类字段可以访问
            id.setAccessible(true);

            //获得字段在对象中的值
            Object idValue = id.get(pGuy);
            //设置字段在对象中的值
            id.set(pGuy, 1);


            Field name = clsCls.getDeclaredField("name");
            name.setAccessible(true);
            Object nameValue = name.get(pGuy);
            name.set(pGuy, "李相赫");

        } catch (NoSuchFieldException | IllegalAccessException ignored) {

        }
    }


    public static void handleObjectMethodAll(Guy pGuy) {
        try {
            //创建类类对象
            Class<Guy> cl = Guy.class;
            //得到目标类中的所有方法
            Method[] methods = cl.getDeclaredMethods();
            //设置方法可以访问
            AccessibleObject.setAccessible(methods, true);
            //遍历方法
            for (Method method : methods) {
                if (method.getName().equals("fuck")) {
                    //执行方法
                    String fuckRet = (String) method.invoke(pGuy, "彭丽媛");

                }

                if (method.getName().equals("die")) {
                    int dieRet = (int) method.invoke(pGuy, 20);
                }
            }

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void handleObjectMethodOne(Guy pGuy) {
        Object o;
        try {
            //创建类类对象
            Class<Guy> cl = Guy.class;

            //得到目标类指定方法
            Method fuck = cl.getDeclaredMethod("fuck", String.class);
            //设置访问权限
            fuck.setAccessible(true);
            //调用方法
            fuck.invoke(pGuy, "宋祖英");

            Method die = cl.getDeclaredMethod("die", int.class);
            die.setAccessible(true);
            die.invoke(pGuy, 22);

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }


}
