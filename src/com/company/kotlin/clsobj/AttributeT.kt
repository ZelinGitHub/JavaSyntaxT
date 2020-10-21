package com.company.kotlin.clsobj


class BigAss {
    val name: String = "Mike"
    var isMarried: Boolean = false
}



fun testAttributeT1() {
    val bigAss = BigAss()
    //引用属性，内部默认调用了set方法
    bigAss.isMarried = false;
    //引用属性，内部默认调用了get方法
    println(bigAss.name)
    println(bigAss.isMarried)
}