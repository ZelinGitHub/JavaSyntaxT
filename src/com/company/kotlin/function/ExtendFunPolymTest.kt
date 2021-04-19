package com.company.kotlin.function

open class Clue
class BigClue : Clue()
fun Clue.foo() = "CCTV"
fun BigClue.foo() = "Big CCTV"
fun testExtendFunPolym() {
    val clue: Clue = BigClue()
    //根据对象变量的类型，决定调用哪个函数
    println(clue.foo())
}

