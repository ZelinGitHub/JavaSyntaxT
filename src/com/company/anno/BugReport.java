package com.company.anno;

import com.company.enumeration.Status;

import java.lang.ref.Reference;


public @interface BugReport {
    boolean showStopper() default  false;
    String assigned() default "fuck";
    Class<?> testCase() default Void.class;
    Status status() default Status.UNCONFIRMED;
    FuckAnnotation ref() default @FuckAnnotation();
    String[] reportedBy();
}
