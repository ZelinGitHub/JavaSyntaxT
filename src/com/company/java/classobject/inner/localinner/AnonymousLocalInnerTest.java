package com.company.java.classobject.inner.localinner;

public class AnonymousLocalInnerTest {

    public void fuckAnonymousClass() {
        new Club("violin") {
            @Override
            public void fuck() {
                super.fuck();
                System.out.println("anonymous son fuck");
            }
        };
    }

    public void fuckAnonymousAbstractClass(){
        new Drug("heroin"){
            @Override
            public void lick() {
                System.out.println("anonymous son lick");
            }
            @Override
            public void fuck() {
                super.fuck();
                System.out.println("anonymous son fuck");
            }
        };
    }


    public void fuckAnonymousInterface(){
        new Duck(){
            @Override
            public void lick() {
                System.out.println("anonymous son lick");
            }
        };
    }

}
