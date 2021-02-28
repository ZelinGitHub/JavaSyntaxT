package com.company.java.classobject.reflect;

import java.lang.reflect.Array;

public class ReflectCreateArrayT {
    public static void createArrayInstanceFromArray(){
        //动态创建数组
        Object array= Array.newInstance(String.class.getComponentType(),10);
    }


//    public static Object badCopyOf(Object[] a,int newLength){
//        //新数组
//        Object[] newArray=new Object[newLength];
//
//
//    }

//    public static Object goodCopyOf(Object a,int newLength){
//
//    }
}
