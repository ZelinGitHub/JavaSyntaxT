package com.company.kotlin.`fun`

import java.lang.StringBuilder

//扩展属性
//不是字段，不能有构造函数
//必须定义属性的get方法
val String.lastChar: Char
    get() = get(length - 1)

//可变引用
//可变引用必须同时具有set和get方法
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    //参数value
    set(value: Char) {
        //省略this
        setCharAt(length - 1, value)
    }

fun sb(){
    //调用get方法
    print("big ass".lastChar)
    val sb=StringBuilder("kotlin")
    //调用set方法
    sb.lastChar='!'
    print(sb)
}