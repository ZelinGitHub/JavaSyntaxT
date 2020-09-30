package com.company.java.concur;

import java.util.concurrent.*;

public class BlockingQueueTest {

    private static void test() {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.add("apple");
        blockingQueue.offer("banana");
        try {
            blockingQueue.put("grape");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String fruit = blockingQueue.remove();
        String fruit1 = blockingQueue.poll();
        try {
            String fruit2 = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String fruit3 = blockingQueue.element();
        String fruit4 = blockingQueue.peek();
        BlockingDeque<String> blockingDeque;
        TransferQueue<String> transferQueue;

        LinkedBlockingQueue<String> aLinkedBlockingQueue = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<String> aLinkedBlockingQueue2 = new LinkedBlockingQueue<>(10);
        ArrayBlockingQueue<String> aArrayBlockingQueue = new ArrayBlockingQueue<>(10);


        SynchronousQueue<String> aSynchronousQueue = new SynchronousQueue<>();
        try {
            aSynchronousQueue.put("abc");
            String str = aSynchronousQueue.take();
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
    }

    public static void test2() {
        SynchronousQueue<String> aSynchronousQueue = new SynchronousQueue<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String data = "85512931781416";
                    System.out.println("线程" + Thread.currentThread().getId() + "发送数据：" + data);
                    aSynchronousQueue.put(data);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String data = aSynchronousQueue.take();
                    System.out.println("线程" + Thread.currentThread().getId() + "收到数据：" + data);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
    }
}
