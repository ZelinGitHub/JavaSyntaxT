package com.company.java.classobject.inner.localinner;

public abstract class Drug {
    private String name = "abc";

    public Drug(String pName) {
        name = pName;
    }

    public void fuck() {
        System.out.println(name);
    }

    public abstract void lick();
}
