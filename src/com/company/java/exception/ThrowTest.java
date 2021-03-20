package com.company.java.exception;

import java.io.IOException;

public class ThrowTest {

    //抛出RuntimeException
    //RuntimeException是不受检异常
    public void throwRuntimeException() {
        throw new RuntimeException();
    }

    //抛出NullPointerException
    //NullPointerException是不受检异常
    public void throwNullPointerException() {
        throw new NullPointerException();
    }

    //声明异常处理受检异常
    public void throwException() throws Exception {
        throw new Exception("ugly fuck");
    }

    //检测+捕获处理受检异常
    public void throwException2() {
        try {
            throw new Exception("ugly fuck");
        } catch (Exception pE) {
            pE.printStackTrace();
        }
    }
    //声明异常处理受检异常
    public void throwIOException() throws IOException {
        throw new IOException();
    }
    //检测+捕获处理受检异常
    public void throwIOException2() {
        try {
            throw new IOException();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }

    public void throwError() {
        throw new Error();
    }


}
