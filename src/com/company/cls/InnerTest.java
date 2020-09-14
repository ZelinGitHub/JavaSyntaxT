package com.company.cls;

public class InnerTest {

    public static void test() {
        final int a = 0;
        class localInnerCls {
            public void fun() {
                System.out.println(a);
            }
        }
        localInnerCls localInnerCls = new localInnerCls();
        localInnerCls.fun();
    }

    public static void test2() {
        final int[] a = {1};
        final Rice rice = new Rice();
        rice.a = 1;
        class localInnerCls {
            public void fun() {
                a[0]++;
                rice.a++;
                System.out.println(a[0]);
                System.out.println(rice.a);
            }
        }
        localInnerCls localInnerCls = new localInnerCls();
        localInnerCls.fun();
    }

    public static void test3() {
        final Rice rice = new Rice();
        rice.a = 1;
        class localInnerCls {
            public void fun() {
                rice.a++;
                System.out.println(rice.a);
            }
        }
        localInnerCls localInnerCls = new localInnerCls();
        localInnerCls.fun();
    }
}
