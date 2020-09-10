package com.company.designmode.templatemethod;

public class CoderComputer extends AbstractComputer{
    @Override
    protected void login() {
        System.out.println("用户名和密码验证登录");
    }
}
