package com.company.concur.unsafe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class VarHandleTest {
    private static VarHandle sVarHandle;
    private int mState;
    public static void test(){
        MethodHandles.Lookup l = MethodHandles.lookup();
        try {
            sVarHandle= l.findVarHandle(VarHandleTest.class, "mState", int.class);
        } catch (NoSuchFieldException | IllegalAccessException pE) {
            pE.printStackTrace();
        }
    }
}
