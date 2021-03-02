package com.company.java.exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DeclareExceptionTest {
    public void declareException() throws IOException {
        InputStream aInputStream = new FileInputStream("/dir/fileX");
        int content = aInputStream.read();
    }
}
