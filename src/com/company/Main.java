package com.company;


import com.company.java.collect.IteratorTest;
import com.company.java.concur.big3.Big3AtomicLongTest;
import com.company.java.concur.big3.Big3SeeTest;
import com.company.java.concur.big3.Big3SeeYieldTest;
import com.company.java.concur.innerlock.SyncChunkTestReturn;
import com.company.java.concur.lock.lock.ReentrantLockReturnTest;
import com.company.java.concur.lock.other.SemaphoreTest;
import com.company.java.concur.threadpool.PoolExecuteTest;
import com.company.java.concur.threadpool.PoolSubmitTest;
import com.company.java.exception.ExceptionTest;

import static com.company.kotlin.lambda.LambdaTestKt.testLambdaTest2;

public class Main {

    public static void main(String[] args) {
        IteratorTest.test();
    }

}
