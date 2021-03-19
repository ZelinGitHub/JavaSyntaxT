package com.company.kotlin.attribute;

public class AttributeTest {
    public static void test() {


        BigAss bigAss = new BigAss();

        String name = bigAss.getName();
        boolean isMarried = bigAss.isMarried();
        bigAss.setMarried(true);
    }

    public void fuckTopAttr(){
        //var属性
        TopAttributeTestKt.getOpCount();
        //var属性
        TopAttributeTestKt.setOpCount(9);
        //val属性
        TopAttributeTestKt.getUNIX_LINE_SEPARATOR();
        //常量
        String str = TopAttributeTestKt.Unix_line_sep;
    }
}
