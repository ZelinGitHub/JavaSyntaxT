package com.company.kotlin.companion;

public class ObjectCompanionTest {
    public static void test() {

        //调用对象声明的方法
        Payroll.INSTANCE.calculateSalary();
        //调用类中对象声明的方法
        Korean.Payroll.INSTANCE.calculateSalary();

        //调用伴生对象的方法
        A.Companion.bar();

        B.She.bar();


    }
}
