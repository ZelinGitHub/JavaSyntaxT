package com.company.java.classobject.reflect;

public class ReflectCreateObjectT {

    /**
     * 利用类类对象创建对象
     */
    public static void createClassObjectFromClsClsObject() {
        try {
            //类类对象
            Class cls=Guy.class;
            //创建对象
            Object o = cls.newInstance();


        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
