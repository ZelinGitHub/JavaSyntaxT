package com.company.java.anno;

public @interface MyAnnotation {
    int id() default -1;
    String msg();
    String value();
}
