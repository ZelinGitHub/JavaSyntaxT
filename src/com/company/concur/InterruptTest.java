package com.company.concur;

public class InterruptTest {

    private static void testX(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是当前线程");
            }
        });
        thread.start();
        thread.isInterrupted();
    }

    private static void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("线程开始执行");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程执行结束");
                    }
                });
                thread.start();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("中断前");
                thread.interrupt();
                System.out.println("中断后");
            }
        }).start();

    }

    private static void test2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean isInProgress = true;
                while (isInProgress) {
                    if (Thread.interrupted()) {
                        System.out.println("线程中断");
                        return;
                    }
                    System.out.println("我是正在运行的线程");
                    isInProgress = false;
                    System.out.println("线程运行结束");
                }
            }
        });

        thread.start();
        thread.interrupt();
    }


    public static void test3() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean isInProgress = true;
                try {
                    while (isInProgress) {
                        System.out.println("我是正在运行的线程");
                        Thread.sleep(3000);
                        isInProgress = false;
                        System.out.println("线程运行结束");
                    }
                } catch (InterruptedException e) {
                    System.out.println("线程中断");
                } finally {
                }
            }
        });
        thread.start();
        thread.interrupt();
    }

    void mySubTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

    void mySubTask2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

    void mySubTask3() throws InterruptedException {
        Thread.sleep(5000);
    }
}
