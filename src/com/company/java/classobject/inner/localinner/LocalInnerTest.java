package com.company.java.classobject.inner.localinner;

public class LocalInnerTest {
    public void fuckLocalInnerJinx() {
        class FuckJinxLocal {
            public void goDie() {
            }
        }
        FuckJinxLocal fuckJinxLocal = new FuckJinxLocal();
        fuckJinxLocal.goDie();
    }

    public void fuckLocalInnerJapan() {
        final String ax = "abc";
        class FuckJapanLocal {
            public void goDie() {
                System.out.println(ax);
            }
        }
        FuckJapanLocal fuckJapanLocal = new FuckJapanLocal();
        fuckJapanLocal.goDie();
    }

    public void fuckLocalInnerArray() {
        final int[] a = {1};
        class localInnerCls {
            public void fun() {
                a[0]++;
                System.out.println(a[0]);
            }
        }
        localInnerCls localInnerCls = new localInnerCls();
        localInnerCls.fun();
    }

    public  void fuckInnerObject() {
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
