package com.company.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketTest {

    public void fuck() {
        try {
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
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }


    public void lick() {
        try {
            Socket socket2 = new Socket();
            InetSocketAddress address = new InetSocketAddress("192.168.0.111", 12);
            socket2.connect(address, 10000);
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }

}
