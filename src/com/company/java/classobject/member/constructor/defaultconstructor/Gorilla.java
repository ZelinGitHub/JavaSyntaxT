package com.company.java.classobject.member.constructor.defaultconstructor;

public class Gorilla {
    public String name;
    public int age=1;
    public int iq=2000;
    public int gender;

    public Gorilla(String pName) {
        name = pName;
        age=100;
        changeIq();
    }

    private void changeIq() {
        iq=3000;
    }

    @Override
    public String toString() {
        return "Gorilla{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", iq=" + iq +
                ", gender=" + gender +
                '}';
    }
}
