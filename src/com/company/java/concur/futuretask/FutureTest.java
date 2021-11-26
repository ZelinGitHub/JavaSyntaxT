package com.company.java.concur.futuretask;

import java.util.concurrent.*;

public class FutureTest {
    interface ArchiveSearcher {
        String search(String target);
    }

    ExecutorService executor = Executors.newSingleThreadExecutor();
    ArchiveSearcher searcher = new ArchiveSearcher() {
        @Override
        public String search(String target) {
            System.out.println("正在查询");
            return "go die";
        }
    };

    void showSearch(String target) throws InterruptedException {
        Callable<String> task = () -> searcher.search(target);
        System.out.println("提交任务到线程池");
        Future<String> future = executor.submit(task);
        try {
            System.out.println("正在试图获取查询结果");
            System.out.println("查询结果：" + future.get());
        } catch (ExecutionException ex) {
            System.out.println("获取查询结果的过程中发生异常");
        }
    }

}
