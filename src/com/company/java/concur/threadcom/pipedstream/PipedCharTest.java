package com.company.java.concur.threadcom.pipedstream;

import java.io.*;

public class PipedCharTest {
    public static void test() {
        final PipedReader reader = new PipedReader();
        final PipedWriter writer = new PipedWriter();

        try {
            // writer.connect(reader);  执行这个效果相同
            reader.connect(writer);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程2：开始执行");
                    try {
                        char[] chars = new char[20];
                        int length = reader.read(chars);
                        String data = new String(chars, 0, length);
                        System.out.println("线程2：收到数据" + data);
                        reader.close();
                    } catch (IOException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException pE) {
                pE.printStackTrace();
                Thread.currentThread().interrupt();
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程1：开始执行");
                    try {
                        String data = "fuck u";
                        System.out.println("线程1：发送数据" + data);
                        writer.write(data);
                        writer.close();
                    } catch (IOException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }
}
