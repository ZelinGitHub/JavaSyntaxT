package com.company.kotlin.generictype

fun printContent(list: List<Any>) {
    println(list.joinToString())
}


fun gogoing() {
    //把list<String>传递给了list<Any>
    printContent(listOf("马云", "马化腾"))

    val strings = mutableListOf<String>("李彦宏", "周鸿祎")
}

fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}

/**
 *  在泛型T上协变
 *  T是一个定义的泛型
 */
interface Producer<out T> {
    fun produce(): T
}
