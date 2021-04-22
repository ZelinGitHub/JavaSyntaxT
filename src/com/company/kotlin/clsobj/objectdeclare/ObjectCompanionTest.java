package com.company.kotlin.clsobj.objectdeclare;

public class ObjectCompanionTest {
    public void fuckKotlinObject() {
        //调用对象声明的方法
        Payroll.INSTANCE.calculateSalary();
        //调用类中对象声明的方法
        Korean.Payroll.INSTANCE.calculateSalary();
    }


}
