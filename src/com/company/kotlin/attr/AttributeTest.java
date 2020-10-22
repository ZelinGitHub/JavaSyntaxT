package com.company.kotlin.attr;

public class AttributeTest {
    public static void test() {
        TopAttributeTestKt.getOpCount();
        TopAttributeTestKt.setOpCount(9);

        TopAttributeTestKt.getUNIX_LINE_SEPARATOR();


        String str = TopAttributeTestKt.Unix_line_sep;

        BigAss bigAss = new BigAss();

        String name = bigAss.getName();
        boolean isMarried = bigAss.isMarried();
        bigAss.setMarried(true);
    }
}
