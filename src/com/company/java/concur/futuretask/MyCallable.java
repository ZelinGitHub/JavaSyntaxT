package com.company.java.concur.futuretask;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("执行任务中");
        return "成功";
    }
}
