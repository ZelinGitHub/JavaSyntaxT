package com.company.java.classobject.implexten.polym;

import com.company.java.datatype.array.Employee;
import com.company.java.datatype.array.Manager;

public class PolymTest {
    public void fuckPolymOut() {
        Drink drink = new Cola();
        Cola cola = new Cola();
        //操作的是父类型中的实例域
        System.out.println(drink.a);
        //操作的是子类型中的实例域
        System.out.println(cola.a);
    }

    public void fuckArrayPolymBug(){
        //创建经理数组
        Manager[] managers = new Manager[10];
        //初始化雇员数组变量为经理数组
        Employee[] staff = managers;
        //设置经理数组的第一个元素为普通雇员
        //编译器不会报错，但运行会报ArrayStoreException
        staff[0]=new Employee();
    }

    public static void test(){
        PolymTest polymTest=new PolymTest();
        polymTest.fuckArrayPolymBug();
    }
}
