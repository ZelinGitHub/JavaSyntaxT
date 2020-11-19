package com.company;


import com.company.java.concur.innerlock.MyInnerLockException;
import com.company.java.concur.innerlock.MyInnerLockFair;
import com.company.java.concur.innerlock.MyInnerLockFather;
import com.company.java.concur.innerlock.MyInnerLockReentrant;
import com.company.java.concur.lock.lock.LockExceptTest;
import com.company.java.concur.lock.reentrant.ReLockFairTest;

public class Main {

    public static void main(String[] args) {
        MyInnerLockFair.test();
    }


}
