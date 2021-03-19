package com.company.kotlin.func;

public class JavaFunc {
    public void callKotlinTopFun() {
        TopFunTestKt.joinToString("Lady");
        System.out.println(ExtendFunTKt.lastChar("Hello America!"));
    }

    public int addNumbers(String name, int... args) {
        int result = 0;
        for (int pArg : args) {
            result += pArg;
        }
        return result;
    }
}
