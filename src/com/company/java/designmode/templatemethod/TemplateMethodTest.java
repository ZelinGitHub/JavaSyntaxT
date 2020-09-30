package com.company.java.designmode.templatemethod;

public class TemplateMethodTest {
    public static void test() {
        AbstractComputer computer1 = new CoderComputer();
        AbstractComputer computer2 = new MilitaryComputer();

        computer1.startUp();
        computer2.startUp();

    }
}
