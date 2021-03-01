package com.company.java.classobject.reflect;

public class CreateObjectTest {


    public void createInstance() {
        try {
            Class cls = Guy.class;
            Object o = cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
