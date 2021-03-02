package com.company.java.classobject.clsloader;

public class ClassLoaderTest {
    public void loadClass() {
        //创建类加载器
        MyClassLoader loader = new MyClassLoader("D:\\src");
        try {
            //调用ClassLoader的loadClass方法，加载class文件到内存并转换为Class实例
            Class c = loader.loadClass("com.example.fuck");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
