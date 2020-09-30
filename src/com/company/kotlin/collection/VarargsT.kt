package com.company.kotlin.collection

fun mains(args:Array<String>){
    //listOf参数是可变参数类型
    //可变参数类型是vararg
    //通过解包运算符*把数组args展开赋给可变参数
    //解包之后可以组合其他固定值
    val list= listOf<String>("arg: ",*args)
}