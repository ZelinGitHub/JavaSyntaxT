package com.company.java.generic.other;

public class WildcardTest {
    private  Human woman=new Human();
    private Human man=new Human();
    private Employee lowlyEmployee = new Employee();
    private Employee highlyEmployee = new Employee();
    private Manager ceo = new Manager();
    private  Manager cfo = new Manager();
    private Pair<Human> humanBuddies = new Pair<>(man, woman);
    private Pair<Manager> managerBuddies = new Pair<>(ceo, cfo);
    private Pair<Employee> employeeBuddies = new Pair<>(lowlyEmployee, highlyEmployee);
    private Object object=new Object();
    public void test() {
        Pair<? extends Employee> wildcardBuddies = null;
        Pair<? extends Integer> pigs = new Pair<>();
//        pigs.mDick=1;
//        pigs.setFirst(1);

        //错误
//employeeBuddies=managerBuddies;
//        wildcardBuddies=humanBuddies;
        wildcardBuddies = employeeBuddies;
        wildcardBuddies = managerBuddies;

        //错误
//        wildcardBuddies.setFirst(ceo);
        //错误
//        wildcardBuddies.mDick=ceo;
        //错误
//        wildcardBuddies.setFirst(employee);
        //错误
//        wildcardBuddies.setFirst(new Object());
        //错误
//        wildcardBuddies.setFirst(new Human());
        //正确
        wildcardBuddies.setFirst(null);
        //正确
         object = wildcardBuddies.getFirstO();
        //正确
        lowlyEmployee = wildcardBuddies.getFirstO();
        //错误
//        ceo=wildcardBuddies.getFirstO()
        //正确
        object = wildcardBuddies.mDick;
        //正确
        lowlyEmployee = wildcardBuddies.mDick;
        //错误
//        ceo=wildcardBuddies.mDick;
    }

    public void exam() {
        Pair<? super Employee> wildcardBuddies = null;
        Pair<? super Integer> pigs = new Pair<>();

        pigs.mDick=1;
        pigs.setFirst(1);

        Pair<? > fuckers = null;

        Pair<Employee> fucker=new Pair<>();
        Pair<Killer> fucker2=new Pair<>();
        Pair<Object> fucker3=new Pair<>();
        Pair<String> fucker4=new Pair<>();

        fuckers=fucker;
        fuckers=fucker2;
        fuckers=fucker3;
        fuckers=fucker4;
        //错误
//        wildcardBuddies=managerBuddies;
        //正确
        wildcardBuddies=employeeBuddies;
        //正确
        wildcardBuddies=humanBuddies;

        //正确
        wildcardBuddies.setFirst(ceo);

        wildcardBuddies.mDick=ceo;
        //正确
        wildcardBuddies.setFirst(lowlyEmployee);
        wildcardBuddies.mDick=lowlyEmployee;
        //正确
        wildcardBuddies.setFirst(null);
        lowlyEmployee=null;
        //错误
//        wildcardBuddies.setFirst(man);

        //错误
//        ceo=wildcardBuddies.mDick;
        //错误
//        lowlyEmployee=wildcardBuddies.mDick;
        //错误
//        man=wildcardBuddies.mDick;
        //正确
         object=wildcardBuddies.mDick;

        //错误
//        ceo=wildcardBuddies.getFirstO();
        //错误
//        lowlyEmployee=wildcardBuddies.getFirstO();
        //错误
//        man=wildcardBuddies.getFirstO();
        //正确
         object=wildcardBuddies.getFirstO();


         Pair<? super JiaBin> friends=new Pair<>();

         object=friends.getFirstO();

        JiaBinSon jiaBinSon=new JiaBinSon();

//        jiaBinSon=friends.getFirstO();

//        JiaBinFather jiaBinFather=friends.mDick;
    }

    public static void beta(){
        Buddy buddy=new Buddy();
        Test.<Buddy>shit(buddy);

        Killer killer=new Killer();
        Test.<Killer>shit(killer);


        Hitler hitler=new Hitler();
        Test.<Hitler>shit(hitler);


    }
}
