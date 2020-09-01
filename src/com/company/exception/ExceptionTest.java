package com.company.exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionTest {
    public static void test() {
        try {
            InputStream aInputStream = new FileInputStream("/dir/fileX");
            int content = aInputStream.read();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }

    public static void test2() throws IOException {
        InputStream aInputStream = new FileInputStream("/dir/fileX");
        int content = aInputStream.read();
    }
}
