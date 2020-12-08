package com.company.java.designmode.sington;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DestroyDCL {
    public static void test() {
        try {
            Constructor<?> constructor = VDCLazySingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            VDCLazySingleton s1 = (VDCLazySingleton) constructor.newInstance();
            VDCLazySingleton s2 = (VDCLazySingleton) constructor.newInstance();
            System.out.println("对象s1："+s1.hashCode());
            System.out.println("对象s2："+s2.hashCode());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException pE) {
            pE.printStackTrace();
        }
    }
}
