package com.company.java.concur.threadcom.pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedByteTest {
    public static void test() {
        final PipedInputStream inputStream = new PipedInputStream();
        final PipedOutputStream outputStream = new PipedOutputStream();

        try {
//            outputStream.connect(inputStream);
            inputStream.connect(outputStream);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程2：开始执行");
                    try {
                        byte[] bytes = new byte[20];
                        int length = inputStream.read(bytes);
                        String data = new String(bytes, 0, length);
                        System.out.println("线程2：收到数据" + data);
                        inputStream.close();
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
                        outputStream.write(data.getBytes());
                        outputStream.close();
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
