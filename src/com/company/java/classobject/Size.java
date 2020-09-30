package com.company.java.classobject;

//Size实际上是继承自Enum的一个类
public enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("EL");

    private String mAbbreviation;

    Size(String pAbbreviation) {
        mAbbreviation = pAbbreviation;
    }

    public String getAbbreviation() {
        return mAbbreviation;
    }

}
