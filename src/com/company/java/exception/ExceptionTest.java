package com.company.java.exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionTest {
    public static void test() {
        try {
            InputStream aInputStream = new FileInputStream("/dir/fileX");
            int content = aInputStream.read();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }

    public static void test2() throws IOException {
        InputStream aInputStream = new FileInputStream("/dir/fileX");
        int content = aInputStream.read();
    }


    public static void test3() {
        try {
            System.out.println("我是try");
            throw new Exception("异常X");
        } catch (Exception pE) {
            System.out.println("我是catch");
            pE.printStackTrace();
        } finally {
            System.out.println("我是finally");
        }
    }

    public static void test4() {
        try {
            System.out.println("我是try");
        } finally {
            System.out.println("我是finally");
        }
    }

    public static void test5() {
        try {
            fuck();
        } catch (Exception pE) {
            pE.printStackTrace();
            System.out.println("no fuck");
        }
    }

    public static void test6() {
        try {
            System.out.println("我是try");
            return;
        } finally {
            System.out.println("我是finally");
        }
    }

    public static void test7() {
        System.out.println(lick());
    }

    public static void test8() {
        try {
            try {
                System.out.println("我正在被检测");
            } finally {
                System.out.println("我是最终处理");
            }
        } catch (Exception pE) {
            System.out.println("我是异常捕获");
            pE.printStackTrace();
        }
    }

    public static void test9() {
        try {
            try {
                System.out.println("我正在被检测");
            } finally {
                System.out.println("我是最终处理");
            }
        } catch (Exception pE) {
            System.out.println("我是异常捕获");
            pE.printStackTrace();
        }
    }
    public static void test10() {
        try {
            fuck2();
        } catch (Exception pE) {
            pE.printStackTrace();
        }
    }

    private static void fuck() throws Exception {
        try {
            throw new Exception("die");
        } finally {
            System.out.println("good die");
        }
    }

    private static void fuck2() throws Exception {
        try {
            try {
                throw new Exception("die");
            } finally {
                System.out.println("good die");
            }
        } finally {
            System.out.println("bad die");
        }
    }

    public static String lick() {
        try {
            return "try";
        } finally {
            return "finally";
        }
    }

}
