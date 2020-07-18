package com.company.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class NetTest {
    public static void testSocket() {
        try {
            InetAddress address2 = InetAddress.getByName("www.google.com");
            String hostName = address2.getHostName();

            byte[] addressBytes = address2.getAddress();
            String addressStr = address2.getHostAddress();

            InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
            InetAddress address3 = InetAddress.getLocalHost();

            //无连接套接字
            Socket socket2 = new Socket();
            //套接字地址
            InetSocketAddress address = new InetSocketAddress("192.168.0.111", 12);
            //连接
            socket2.connect(address, 10000);
            //带连接套接字
            Socket socket = new Socket("192.168.0.111", 12);

            //输入流
            InputStream inputStream = socket.getInputStream();

            //输出流
            OutputStream outputStream = socket.getOutputStream();
            socket.setSoTimeout(10000);

            //半关闭
            socket.shutdownInput();
            socket.shutdownOutput();

            ServerSocket serverSocket = new ServerSocket(8189);
            Socket socket1 = serverSocket.accept();

            InputStream inputStream1 = socket1.getInputStream();

            OutputStream outputStream1 = socket1.getOutputStream();
            serverSocket.close();
            int a=1;
            int b=2;
            int max  =(a>b)?a:b;

            while (true) {
                //没有客户端连接会阻塞
                Socket socket3 = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        process(socket3);
                    }
                }).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void process(Socket socket3) {
        try {
            InputStream inputStream2 = socket3.getInputStream();
            OutputStream outputStream2 = socket3.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
