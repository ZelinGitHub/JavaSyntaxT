package com.company.java.classobject.reflect;

import java.lang.reflect.Array;

public class CreateArrayTest {
    public void createArray() {
        Object array = Array.newInstance(String.class.getComponentType(), 10);
    }
}
