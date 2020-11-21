package com.company;


import com.company.java.concur.innerlock.MyLockAtomic;
import com.company.java.concur.unsafe.AtomicIntegerTest;
import com.company.java.concur.unsafe.AtomicIntegerTest2;
import com.company.java.concur.vol.VolatileTest3;

public class Main {

    public static void main(String[] args) {
        MyLockAtomic.test();
    }


}
