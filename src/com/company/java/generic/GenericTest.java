package com.company.java.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {


    public <G> void kick(G girl) {
        System.out.println("FUck " + girl.toString());
    }


    public static <G> void lick(G pG) {
        System.out.println("Lick " + pG.toString());
    }

    //类型变量G的值限定为Father或Father的子类型
    public static <G extends Father> void hit(G pG) {
        System.out.println("Lick " + pG.toString());
    }

    public static <G> G lick3(G pG) {
        return pG;
    }

    public static <G, K> void lick2(G pG, K pK) {
        System.out.println("Lick " + pG.toString() + pK.toString());
    }


    public static void addA(List<? extends String> pList) {
//        pList.add("abc");
//        pList.set(0,"abc");
        pList.remove(0);
        String str = pList.get(0);
    }

    public static <FUCK extends String> void bin(FUCK pFUCK) {

    }

    public void dig() {
        //必须写明调用者，才可以传递类型参数
        this.<String>kick("apple");
        //不传递类型参数，编译器会尝试推断泛型参数的类型
        kick("orange");
    }

    public void fight() {
        GenericTest genericTest = new GenericTest();
        //必须写明调用者，才可以传递类型参数
        genericTest.<String>kick("Lady");
        //不传递类型参数，编译器会尝试推断泛型参数的类型
        genericTest.kick("banana");
    }

    public void suck() {
        //必须写明调用者，才可以传递类型参数
        GenericTest.<String>lick("Asshole");
        //不传递类型参数，编译器会尝试推断泛型参数的类型
        GenericTest.lick("meat");
    }

    public void hate() {
        //定义变量时，应该传递类型参数，如果不传递会出现警告
        Pair pair;
        Pair<String> pair2;
        Pair<Integer> pair1 = new Pair<Integer>();
        //构造方法的类型参数可以省略，只剩一个尖括号
        Pair<Long> pair3 = new Pair<>();
        List<String> list;
        List<String> list2 = new ArrayList<>();
    }

    public void like() {
        Pair<String> pair = new Pair<String>("Galapagos", "Madagascar");
        //内部转换Object为String
        String galapagos = pair.getFirst();
        //内部转换Object为String
        String madagascar = pair.getSecond();
    }

    public void bent() {
        GenericTest.<Child>hit(new Child());
        GenericTest.<Father>hit(new Father());
    }

    public static void test() {

        List<String> list = new ArrayList<>();


        List<String> list1 = new ArrayList<String>();

        list1.addAll(list);

        List<?> list2 = new ArrayList<>();
        list2.add(null);
        list2.set(0, null);
        Object object = list2.get(0);

        List list3 = new ArrayList();
        list3.add("abc");
        list3.add(new Object());
        list3.add(null);
        list3.set(0, null);

        list3 = new ArrayList<String>();
        list3 = new ArrayList<Object>();
        list3 = new ArrayList<Integer>();
        list3 = new ArrayList<Boolean>();

        Coke coke;
        coke = new Coke<String>();
        coke = new Coke<Object>();
        coke.mT = "abc";
        Object object2 = coke.mT;

        Cola cola = new Cola();
//        cola=new Cola<Child>();


        Coke<?> coke1 = new Coke<>();
//        String str=coke1.mT;//错误，? 不是String的子类型
        Object obj = coke1.mT;//正确，? 是Object的子类型

        Cola<?> cola2 = new Cola<>();
        Father father = cola2.mT;//正确， ? 是Father的子类型
        Object object3 = cola2.mT;//正确， ? 是Object的子类型
//        Child child=cola2.mT;//错误， ? 不是Child的子类型
        cola2.mT = null;

//        cola2.mT=new Child();;//错误， Child不是 ? 的子类型

        Cola<? super Child> cola1 = new Cola<>();

        cola1.mT = new Child();//正确，Child是 ? super Child的子类型
        cola1.mT = new GoodChild();//正确，GoodChild是 ? super Child的子类型
//        cola1.mT=new Father();//错误，Father不是 ? super Child的子类型

//        Child child1=cola1.mT;//错误，? super Child 不是Child的子类型
        Father father1 = cola1.mT;//正确，? super Child 是Father的子类型
        Object object4 = cola1.mT;//正确，? super Child 是Object的子类型

        Coke<? super Object> coke2;
        Coke<? super String> coke3;

        Cola<?> cola3 = new Cola<>();


        Object object5 = cola3.mT;
        Father father2 = cola3.mT;
        cola3.mT = null;

        Xuebi<? extends Father> xuebi = new Xuebi<>();
        Father father3 = xuebi.mT;
        Child child = xuebi.mT;
//        GoodChild goodChild=xuebi.mT;
    }


}
