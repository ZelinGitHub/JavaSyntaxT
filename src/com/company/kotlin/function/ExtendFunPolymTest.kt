package com.company.kotlin.function

open class Clue
class BigClue : Clue()

fun Clue.foo() = "CCTV"
fun BigClue.foo() = "Big CCTV"
fun testExtendFunPolym() {
    val clue: Clue = BigClue()
    println(clue.foo())
}

