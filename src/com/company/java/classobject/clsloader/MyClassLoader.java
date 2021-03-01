package com.company.java.classobject.clsloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    //class文件的路径
    private String mPath;

    public MyClassLoader(String pPath) {
        mPath = pPath;
    }

    //重写findClass方法
    //调用loadClassData方法，加载Class文件为字节数组
    //调用系统的defineClass方法，转换Class字节数组为Class
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz=null;
        //class文件的字节数组
        byte[] classData=loadClassData(name);
        if(classData==null){
            throw new ClassNotFoundException();
        }else {
            clazz=defineClass(name,loadClassData(name),0,0);
        }

        return clazz;
    }


    //用文件输入流把Class文件加载到内存，得到字节数组
    private byte[] loadClassData(String name){
        //class文件的文件对象
        File file=new File(mPath,name);
        InputStream in=null;
        ByteArrayOutputStream out=null;
        try{
            //class文件的文件输入流
            in=new FileInputStream(file);
            //字节数组输出流
            out=new ByteArrayOutputStream();
            byte[] buffer=new byte[1024];
            int length=0;
            //读入数据到数组buffer
            while((length=in.read(buffer))!=-1){
                //把buffer数据用字节数组输出流写出到内存
                out.write(buffer,0,length);
            }
            //得到字节数组输出流写出的数据
            return out.toByteArray();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(in!=null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try{
                if(out!=null){
                    out.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }

}
