package com.company.java.designmode.templatemethod;

public class MilitaryComputer extends AbstractComputer{
    @Override
    protected void checkHardware() {
        super.checkHardware();
        System.out.println("检查硬件防火墙");
    }

    @Override
    protected void login() {
        System.out.println("指纹识别、虹膜识别验证登录");
    }
}
