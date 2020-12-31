package com.company.java.classobject.inner;

public class Bird {
    public static Chick sChick = new Chick();

    static class Chick {
        public void fly() {
            System.out.println("fly");
        }

        public static void swim() {
            System.out.println("swim");
        }
    }

    public static void test(){
        Bird.Chick chick = new Bird.Chick();
        chick.fly();
        Bird.Chick.swim();
    }
}