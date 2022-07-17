package com.company.java.classobject.member.constructor.defaultconstructor;

public class Chimpanzee {
    private int age=1;
    private int gender;
    private String name="faker";
    private Melon mMelon=new Melon();
    private Peach mPeach=new Peach(age,gender,name);
    private Banana mBanana=new Banana(age,gender,name);


    public Chimpanzee(int pAge, int pGender, String pName) {
        age = pAge;
        gender = pGender;
        name = pName;
        System.out.println("chimpanzee: age: "+age+", gender: "+gender+", name: "+name);
    }
}
