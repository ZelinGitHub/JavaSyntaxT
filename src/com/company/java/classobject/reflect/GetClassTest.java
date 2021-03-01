package com.company.java.classobject.reflect;

public class GetClassTest {


    /**
     * 从类的class成员，得到目标类的Class
     */
    public void getClsFromStaticNumberCls() {

        Class intCls = int.class;
        System.out.println(intCls.getName());

        Class guyClass = Guy.class;
        System.out.println(guyClass.getName());

        Class intArrayClsCls = int[].class;
        System.out.println(intArrayClsCls.getName());

    }


    /**
     * 通过完整类名，得到Class
     */
    public void getClsFromClassFullName() {
        String className = "com.company.java.classobject.reflect.Guy";
        try {
            Class cls = Class.forName(className);
            System.out.println(cls.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用Object的getClass方法，得到Class
     */
    public void getCls() {
        Guy e = new Guy();
        Class cls = e.getClass();
        System.out.println(cls.getName());
    }


    public static void test(){
        GetClassTest getClassTest=new GetClassTest();
        getClassTest.getCls();
    }
}
