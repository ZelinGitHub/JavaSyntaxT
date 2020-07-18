package com.company.concur;

import java.util.concurrent.*;

public class BlockingQueueTest {

    private static void testBlockingQueue() {
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

        BlockingQueue blockingQueue1 = new LinkedBlockingQueue();
        BlockingQueue blockingQueue2 = new LinkedBlockingQueue(10);
        BlockingQueue blockingQueue3 = new ArrayBlockingQueue(10);
        BlockingQueue blockingQueue4 = new ArrayBlockingQueue(10, true);
        BlockingQueue blockingQueue5 = new SynchronousQueue();
        BlockingQueue blockingQueue6 = new SynchronousQueue(true);

        LinkedBlockingDeque linkedBlockingDeque;
        PriorityBlockingQueue priorityBlockingQueue;
        DelayQueue delayQueue;
        LinkedTransferQueue linkedTransferQueue;
        ArrayBlockingQueue arrayBlockingQueue;
        SynchronousQueue synchronousQueue;
    }

}
