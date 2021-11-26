package com.company.java.concur.threadpool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

class SerialExecutor implements Executor {
    final Queue<Runnable> tasks = new ArrayDeque<>();
    final Executor executor;
    Runnable active;

    SerialExecutor(Executor executor) {
        this.executor = executor;
    }

    public synchronized void execute(Runnable r) {
        //添加Runnable到队列，并没有执行Runnable
        tasks.add(() -> {
            try {
                r.run();
            } finally {
                //执行完一个任务之后，继续从队列取出下一个任务执行
                scheduleNext();
            }
        });
        //调用scheduleNext方法
        //active==null判断保证多次调用execute方法时，只有第一次调用时执行scheduleNext方法
        if (active == null) {
            scheduleNext();
        }
    }

    protected synchronized void scheduleNext() {
        //从队列取出Runnable并执行
        if ((active = tasks.poll()) != null) {
            executor.execute(active);
        }
    }
}

