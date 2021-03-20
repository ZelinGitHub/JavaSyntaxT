package com.company.kotlin.attribute

val String.lastChar: Char
    get() {
        return get(length - 1)
    }

var StringBuilder.lastChar: Char
    get() {
        return get(length - 1)
    }
    set(value: Char) {
        setCharAt(length - 1, value)
    }

fun fuckExtendAttribute(){
    val str1:String="abc";
    val str2:StringBuilder=java.lang.StringBuilder("cde")

    val lc:Char=str1.lastChar

    val lc2=str2.lastChar
}