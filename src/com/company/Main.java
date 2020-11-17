package com.company;


import com.company.java.concur.lock.CountDownLatchTest;
import com.company.java.concur.lock.lock.LockInterruptiblyTest;
import com.company.java.concur.lock.lock.LockTest;
import com.company.java.concur.lock.lock.TryLockMilliTest;
import com.company.java.concur.lock.lock.TryLockTest;
import com.company.java.concur.unsafe.LockSupportTest;
import com.company.java.operator.BitCalculateTest;
import com.company.java.var.VarTest;

public class Main {

    public static void main(String[] args) {
        LockSupportTest.testInterrupt2();
    }


}
