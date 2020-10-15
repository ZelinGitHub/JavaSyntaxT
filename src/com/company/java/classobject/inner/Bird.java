package com.company.java.classobject.inner;

public class Bird {
    public static Chick sChick = new Chick();

    static class Chick {
        public void fly() {
            System.out.println("fly");
        }

        public void swim() {
            System.out.println("swim");
        }
    }
}