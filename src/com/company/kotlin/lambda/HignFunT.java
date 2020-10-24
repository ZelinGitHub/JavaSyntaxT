package com.company.kotlin.lambda;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

import static com.company.kotlin.lambda.HighFuncParamTestKt.processTheAnswer;


public class HignFunT {
    public static void o() {
        //调用kotlin函数，传递java8 的lambda
        processTheAnswer(number -> number + 1);

        /**
         * 调用kotlin函数，传递kotlin定义的Function系列接口匿名实现类对象
         * invoke函数体就是lambda的函数体
         */

        processTheAnswer(new Function1<Integer, Integer>() {
            @Override
            public Integer invoke(Integer pInteger) {
                return pInteger + 1;
            }
        });


        List<String> strings = new ArrayList<>();
        strings.add("42");
        //在java中调用kotlin标准函数库，参数2是java中的lambda，这个函数是kotlin的扩展函数，参数1是接收者
        CollectionsKt.forEach(strings, s -> {
            System.out.println(s);
            //Unit类型返回值的lambda必须返回Unit
            return Unit.INSTANCE;
        });
    }
}
