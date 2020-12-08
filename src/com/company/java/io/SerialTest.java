package com.company.java.io;

import java.io.*;

public class SerialTest {
    private void serial() {
        try {
            Wolf wolf = new Wolf();
            wolf.setId("001");
            wolf.setName("Tom");
            wolf.setType("中华田园犬");
            FileOutputStream fileOutputStream = new FileOutputStream("cache.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(wolf);
            outputStream.close();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }

    private void antiSerial() {
        try {
            FileInputStream fileInputStream = new FileInputStream("cache.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Wolf wolf = (Wolf) objectInputStream.readObject();
            System.out.println(wolf);
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException pE) {
            pE.printStackTrace();
        }
    }

    public static void test(){
        SerialTest serialTest=new SerialTest();
        serialTest.serial();
        serialTest.antiSerial();
    }
}
