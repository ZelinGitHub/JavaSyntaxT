package com.company.anno;

public @interface MyAnnotation {
    int id() default -1;
    String msg();
    String value();
}
