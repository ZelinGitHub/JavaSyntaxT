package com.company.kotlin.clsobj.companion;

public class ObjectCompanionTest {
    public void fuckKotlinObject() {
        //调用对象声明的方法
        Payroll.INSTANCE.calculateSalary();
        //调用类中对象声明的方法
        Korean.Payroll.INSTANCE.calculateSalary();
    }

    public void fuckKotlinCompanion() {
        //调用伴生对象的方法
        A.Companion.bar();
        //调用伴生对象的方法
        B.She.bar();
    }
}
