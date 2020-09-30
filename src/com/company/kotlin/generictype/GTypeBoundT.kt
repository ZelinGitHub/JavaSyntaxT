package com.company.kotlin.generictype

import java.lang.Appendable
import java.lang.StringBuilder

fun testAPC(){
    println(oneHalf(3))

    println(max("kotlin", "java"))

    val helloWorld = StringBuilder("fuckYourMother")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)

    //使用可空类型实现泛型T
    val nullaableStringProcessor = Processor<String?>()
    nullaableStringProcessor.process(null)
}

/**
 * 定义约束
 * 泛型上界
 * 泛型类型参数约束
 */
fun <T : Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}

/**
 * 指定泛型上界Comparable<T>
 */
fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

/**
 * where指定多个泛型约束
 * 两个泛型上界
 */
fun <T> ensureTrailingPeriod(seq: T)
        where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

/**
 * 没有指定泛型上界的类型形参的上界默认是Any?，是可空类型
 */
class Processor<T> {
    fun process(value: T) {
        //安全调用
        value?.hashCode()
    }
}

/**
 * 手动指定非空上界
 */
class Processor2<T : Any> {
    fun process(value: T) {
        //安全调用
        value?.hashCode()
    }
}