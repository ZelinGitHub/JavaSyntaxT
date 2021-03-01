package com.company.java.classobject.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射分析对象
 */
public class HandleMemberTest {
    public static void handleField(Guy pGuy) {
        try {
            Class<Guy> clsCls = Guy.class;
            Field id = clsCls.getDeclaredField("id");
            id.setAccessible(true);
            Object idValue = id.get(pGuy);
            id.set(pGuy, 1);
            Field name = clsCls.getDeclaredField("name");
            name.setAccessible(true);
            Object nameValue = name.get(pGuy);
            name.set(pGuy, "李相赫");
        } catch (NoSuchFieldException | IllegalAccessException ignored) {

        }
    }

    public static void handleFields(Guy pGuy) {
        try {
            Class<Guy> clsCls = Guy.class;
            Field[] fields = clsCls.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field field : fields) {
                if (field.getName().equals("id")) {
                    field.set(pGuy, 213);
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


    public static void handleMethod(Guy pGuy) {
        Object o;
        try {
            Class<Guy> cl = Guy.class;
            Method fuck = cl.getDeclaredMethod("fuck", String.class);
            fuck.setAccessible(true);
            fuck.invoke(pGuy, "宋祖英");
            Method die = cl.getDeclaredMethod("die", int.class);
            die.setAccessible(true);
            die.invoke(pGuy, 22);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void handleMethods(Guy pGuy) {
        try {
            Class<Guy> cl = Guy.class;
            Method[] methods = cl.getDeclaredMethods();
            AccessibleObject.setAccessible(methods, true);
            for (Method method : methods) {
                if (method.getName().equals("fuck")) {
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

}
