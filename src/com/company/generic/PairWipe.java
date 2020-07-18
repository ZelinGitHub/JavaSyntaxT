package com.company.generic;

public class PairWipe {
    private Object first;
    private Object second;

    public PairWipe() {
        first = null;
        second = null;
    }

    public PairWipe(Object pFirst, Object pSecond) {
        first = pFirst;
        second = pSecond;
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }

    public void setFirst(Object pFirst) {
        first = pFirst;
    }

    public void setSecond(Object pSecond) {
        second = pSecond;
    }

    public void dig() {
        Object t;
    }
}
