package com.company.kotlin.lambda

fun createAllDoneRunnable():Runnable{
    //Sam构造方法
    //Sam构造方法只接受一个lambda参数
    return Runnable { println("吃屎去吧") }

}