package com.company.java.anno;

import com.company.java.classobject.enumeration.Status;


public @interface BugReport {
    boolean showStopper() default  false;
    String assigned() default "fuck";
    Class<?> testCase() default Void.class;
    Status status() default Status.UNCONFIRMED;
    FuckAnnotation ref() default @FuckAnnotation();
    String[] reportedBy();
}
