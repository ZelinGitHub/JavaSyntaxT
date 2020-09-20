package com.company.classobject;

import com.company.classobject.implexten.Apple;
import com.company.classobject.implexten.BigApple;
import com.company.classobject.implexten.BlueApple;
import com.company.classobject.implexten.YellowBigApple;
import com.company.classobject.polym.Cola;
import com.company.classobject.polym.Drink;

public class ClassObjectTest {
    public static void test1(){
        Apple apple=new BlueApple();
        kick(apple);
        Apple apple1=new YellowBigApple();
        kick(apple1);
        BigApple bigApple=new YellowBigApple();
        kick(bigApple);
        YellowBigApple yellowBigApple=new YellowBigApple();
        kick(yellowBigApple);
    }
    public static void test2(){
        Drink drink=new Cola();
        System.out.println(drink.a);

        Cola cola=new Cola();
        System.out.println(cola.a);
    }
    public static void kick(Apple pApple){

    }
}
