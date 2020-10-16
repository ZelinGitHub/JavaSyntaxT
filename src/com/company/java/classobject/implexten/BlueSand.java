package com.company.java.classobject.implexten;

public class BlueSand extends Sand {
    private String mFName = super.name;

    public void lick() {
        String fName = super.name;
    }

    public void kick() {
        super.fuck();
    }

    @Override
    protected void fuck() {
        super.fuck();
        System.out.println("BlueSand fuck");
    }

//    @Override
//    protected void kill() {
//        super.kill();
//        System.out.println("BlueSand kill");
//    }
}
