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

    public void testExtendFunExtend(){
        Phone phone=new Phone();
        Nokia nokia=new Nokia();

        Planet planet=new Mars();
        Mars mars=new Mars();

        //父调用Kotlin类型定义的扩展函数
        // Java方法重载 精准匹配
        ExtendFunExtendTestKt.call(phone);
        //调用Kotlin子类型从父类型继承的扩展函数
        // Java方法重载 模糊匹配
        ExtendFunExtendTestKt.call(nokia);
        //调用Kotlin父类型定义的扩展函数
        // Java方法重载 精准匹配
        ExtendFunExtendTestKt.expand(planet);
        //调用Kotlin子类型从父类型继承的扩展函数
        // Java方法重载 模糊匹配
        ExtendFunExtendTestKt.expand(mars);
    }

    public void testExtendFunPolym(){
        Clue clue=new Clue();
        BigClue bigClue=new BigClue();
        //调用Kotlin父类型定义的扩展函数
        // Java方法重载 精准匹配
        ExtendFunPolymTestKt.foo(clue);

        //调用Kotlin子类型定义的扩展函数
        // Java方法重载 精准匹配
        ExtendFunPolymTestKt.foo(bigClue);
    }
}
