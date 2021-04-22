package com.company.kotlin.clsobj.companion;

public class KotlinCompanionTest {
    public void fuckKotlinCompanion() {
        //伴生对象对应外围类的静态字段
        //调用伴生对象的方法
        Lion.Dick.fuck();

        //伴生对象对应外围类的静态字段
        //调用伴生对象的方法
        Tiger.Companion.eat();

        Animal.Head.explode();

        Plant.Companion.extend();
    }
}
