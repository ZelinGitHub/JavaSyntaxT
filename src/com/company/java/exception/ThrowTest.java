package com.company.java.exception;

public class ThrowTest {

    public void throwException() throws Exception {
        throw new Exception("ugly fuck");
    }

    public void throwException2()  {
        try {
            throw new Exception("ugly fuck");
        } catch (Exception pE) {
            pE.printStackTrace();
        }
    }



}
