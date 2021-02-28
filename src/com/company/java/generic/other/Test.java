package com.company.java.generic.other;

public class Test {
    public static <T> int getMiddle(T... a) {
        T t = a[a.length / 2];
        return 0;
    }

    public <U> U fuck(U pU) {
        return pU;
    }

    public <H> int kill() {
        return 0;
    }

    public static <T> T getSuck(T... a) {
        T result = a[a.length / 2];
        return result;
    }

    public static <T> int getY() {
        return 0;
    }

    public <T> int getJin() {
        return 0;
    }

    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T smallest = a[0];
        for (int i = 1; i < a.length; i++){
            if (smallest.compareTo(a[i]) > 0) smallest = a[i];
        }
        return smallest;
    }

    //<T extends 类型变量限定，限定类型变量必须是Buddy的子类
    //<? super T> 通配符实现Buddy类
    public static <T extends Buddy<? super T>>T shit(T a){
        return a;
    }
}
