package com.company.concur;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTastTest {

    private static void testFutureTask() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("第" + i + "秒");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                return "fuck";
            }
        };
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        new Thread(futureTask).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before cancel");
        System.out.println(futureTask.cancel(true));
        System.out.println("after cancel");
        try {
//            if(!futureTask.isCancelled()){
            System.out.println("before get");
            System.out.println(futureTask.get());
            System.out.println("after get");
//            }
        } catch (InterruptedException | ExecutionException | CancellationException ex) {
            ex.printStackTrace();
        }
    }

}
