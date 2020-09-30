package com.company.java.generic;

public class RedPhoto extends Photo<String> {
    @Override
    public void setImg(String pS) {
        System.out.println("RedPhoto"+pS);
    }
}
