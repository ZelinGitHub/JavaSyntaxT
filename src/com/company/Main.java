package com.company;


import com.company.java.concur.lock.lock.ReentrantLockFairTest;
import com.company.java.concur.lock.lock.ReentrantLockHasQueuedTest;
import com.company.java.concur.lock.lock.ReentrantLockHoldCountTest;
import com.company.java.concur.lock.lock.ReentrantLockQueueLengthTest;
import com.company.java.concur.lock.readwrite.ReadLockTest;
import com.company.java.concur.lock.readwrite.ReadWriteLockTest;
import com.company.java.concur.lock.readwrite.WriteLockTest;
import com.company.java.concur.lock.readwrite.WriteReadLockTest;
import com.company.java.concur.threadcom.condition.ProConCrossTest;
import com.company.java.concur.threadcom.condition.ReentrantConNTest;
import com.company.java.concur.threadcom.condition.ReentrantConSingleTest;
import com.company.java.concur.threadcom.condition.ReentrantConSortTest;

public class Main {

    public static void main(String[] args) {
        WriteReadLockTest.test2();
    }

}
