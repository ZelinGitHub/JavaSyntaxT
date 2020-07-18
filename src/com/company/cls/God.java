package com.company.cls;

public class God {
    private final int a = 7;
    private  int b;

    private int c = 8;
    private final int d = 10;

    private God(int b) {
        this.b = b;
    }

    public God(int b, int c) {
        this(b);

        this.b = b;

        this.c = c;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
