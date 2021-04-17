package com.company.kotlin.function;

public class JavaFunTest {
    public void callKotlinTopFun() {
        TopFunTestKt.joinToString("Lady");
        System.out.println(ExtendFunTestKt.lastChar("Hello America!"));
    }

    public int addNumbers(String name, int... args) {
        int result = 0;
        for (int pArg : args) {
            result += pArg;
        }
        return result;
    }

    public void testExtendFun(){
        ExtendFunExtendTestKt.testExtendFunExtend();
        ExtendFunImplTestKt.testExtendFunImpl();
        ExtendFunPolymTestKt.testExtendFunPolym();

        Phone phone=new Phone();
        Nokia nokia=new Nokia();
        ExtendFunExtendTestKt.call(phone);
        ExtendFunExtendTestKt.call(nokia);


        Planet planet=new Mars();
        Mars mars=new Mars();
        ExtendFunImplTestKt.expand(planet);
        ExtendFunImplTestKt.expand(mars);


        Clue clue=new Clue();
        BigClue bigClue=new BigClue();
        ExtendFunPolymTestKt.foo(clue);
        ExtendFunPolymTestKt.foo(bigClue);
    }
}
