package com.company.kotlin.collection

fun fuckk(){
    //定义List<String>类型引用
    val strings:List<String>
    = listOf("f","s","d")
    //调用扩展函数
    strings.last()

    val numbers:Collection<Int>
    = setOf(1,2,3)
    //调用扩展函数
    numbers.max()
}