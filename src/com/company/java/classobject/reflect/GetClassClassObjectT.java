package com.company.java.classobject.reflect;

public class GetClassClassObjectT {
    /**
     * 得到类类对象，从目标类某个对象的getClass方法
     */
    public static void getClsClsObjectFromClassObject() {
        Guy e = new Guy();
        //得到Class对象，Class对象代表类
        Class clsCls = e.getClass();

        System.out.println("Class类对象：" + clsCls.getName() + " ；对象：" + e.toString());
    }

    /**
     * 得到类类对象，从目标类的名字
     */
    public static void getClsClsObjectFromClassName() {
        String className = "com.fk.android.reflectt.Guy";
        try {
            Class clsCls = Class.forName(className);
            System.out.println("Class类对象：" + clsCls.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 得到类类对象，从目标类的class静态成员
     */
    public static void getClsClsObjectFromClassMemberClass() {
        Class clsCls = Guy.class;
        System.out.println("Class类对象：" + clsCls.getName());

        Class intArrayClsCls = int[].class;
        System.out.println("Class类对象：" + intArrayClsCls.getName());

    }



}
