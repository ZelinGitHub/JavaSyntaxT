package com.company.kotlin.func

fun callJavaFunc(){
    val numbers:IntArray = intArrayOf(1, 2, 3, 4, 5)
    val javaFunc=JavaFunc()
    javaFunc.addNumbers("add", *numbers)
}