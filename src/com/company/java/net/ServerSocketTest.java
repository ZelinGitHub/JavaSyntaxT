package com.company.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
    public void fuck() {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            Socket socket1 = serverSocket.accept();
            InputStream inputStream1 = socket1.getInputStream();
            OutputStream outputStream1 = socket1.getOutputStream();
            serverSocket.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void lick() {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            while (true) {
                Socket socket3 = serverSocket.accept();
                process(socket3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void process(Socket pSocket3) throws IOException {
        InputStream inputStream2 = pSocket3.getInputStream();
        OutputStream outputStream2 = pSocket3.getOutputStream();
    }
}
