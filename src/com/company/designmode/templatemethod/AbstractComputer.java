package com.company.designmode.templatemethod;

public abstract class AbstractComputer {
    protected void powerOn() {
        System.out.println("开启电源");
    }

    protected void checkHardware() {
        System.out.println("硬件检查");
    }

    protected void loadOS() {
        System.out.println("载入操作系统");
    }

    protected void login() {
        System.out.println("直接登录");
    }

    public final void startUp() {
        powerOn();
        checkHardware();
        loadOS();
        login();
    }
}
