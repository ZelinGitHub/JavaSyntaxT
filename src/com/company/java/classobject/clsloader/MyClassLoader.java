package com.company.java.classobject.clsloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    //class文件的路径
    private final String mPath;

    public MyClassLoader(String pPath) {
        mPath = pPath;
    }

    /*
    重写findClass方法
    加载class文件为字节码
    调用ClassLoader的defineClass方法，转换class文件字节码为Class实例
     */
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        Class cls = null;
        //class文件的字节数组
        byte[] classData = loadClassBytes(className);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            cls = defineClass(className, loadClassBytes(className), 0, 0);
        }
        return cls;
    }


    /*
    用文件输入流，把class文件加载到内存，得到class文件的字节码
     */
    private byte[] loadClassBytes(String name) {
        //class文件的File对象
        File file = new File(mPath, name);
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length = 0;
                //使用FileInputStream，读入class文件到buffer
                while ((length = in.read(buffer)) != -1) {
                    //使用ByteArrayOutputStream，把buffer写出到内存
                    out.write(buffer, 0, length);
                }
                return out.toByteArray();
            } finally {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
