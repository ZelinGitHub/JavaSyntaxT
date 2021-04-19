package com.company.kotlin.function

fun callJavaFunc(){
    val numbers:IntArray = intArrayOf(1, 2, 3, 4, 5)
    val javaFunc= JavaFunTest()
    javaFunc.addNumbers("add", *numbers)
}