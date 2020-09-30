package com.company.kotlin.generictype


import java.lang.IllegalArgumentException
import java.util.*

fun test() {
    val list1: List<String> = listOf("a", "b")
    val list2: List<Int> = listOf(1, 2, 3)
//as?可以检测set和List不同的异常，抛出IllegalArgumentException异常
    printSum(setOf(1, 2, 3))
    //as?不能检测泛型不匹配的异常，因为泛型运行中擦除了，所以抛出ClassCastException
    printSum(listOf("a", "b", "c"))
    printSum(listOf(1, 2, 3))

    //输出true isA是内联函数 泛型是reified泛型
    println(isA<String>("abc"))
    //输出false
    println(isA<String>(123))

    val items=listOf("one",3,"three")
    //过滤出字符串类型的 filterIsInstance是inline函数，String是reified泛型
    println(items.filterIsInstance<String>())

    /**
     * ::class.java是ava类字节码对应的kotlin类字节码，等价于java的Service.class
     * ServiceLoader.load函数参数是一个字节码
     */

}

/*
*星号是星号投影，星号投影是未知类型的泛型
 */
fun printSum(c: Collection<*>) {
    //as?安全转换
    //?:空合并运算符
    val intList = c as? List<Int>
            ?: throw IllegalArgumentException("只能是List")
    println(intList.sum())

}

/**
 * i因为编译期已经知道泛型的类型了，所以is检查是允许的
 */
fun printSum3(c: Collection<Int>) {
    if (c is List<Int>) {
        println(c.sum())
    }
}

/**
 *  内联函数用reified标记的类型参数可以被实化
 */
inline fun <reified T> isA(value: Any) = value is T

