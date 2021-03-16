package com.company.java.classobject.implexten;

public class ImplextenTest {

    public void fuckImplexten() {
        Apple apple = new BlueApple();
        kick(apple);
        Apple apple1 = new YellowBigApple();
        kick(apple1);
        BigApple bigApple = new YellowBigApple();
        kick(bigApple);
        YellowBigApple yellowBigApple = new YellowBigApple();
        kick(yellowBigApple);
    }

    public void kick(Apple pApple) {

    }
}
