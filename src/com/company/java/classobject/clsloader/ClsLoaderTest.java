package com.company.java.classobject.clsloader;

public class ClsLoaderTest {
    public static void test(){
        MyClassLoader myClassLoader=new MyClassLoader("D:\\src");
        try{
            Class c=myClassLoader.loadClass("com.example.fuck");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
