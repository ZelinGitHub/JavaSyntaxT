package com.company.kotlin.basic

import java.lang.IllegalStateException

fun dmc() {
    //kotlin不区分基本数据类型和包装类
    val i: Int = 1
    val list: List<Int> = listOf(1, 2, 3)

    //kotlin必须显示转换变量类型
    val l: Long = i.toLong()

    //默认Int
    val x = 1
    //kotlin必须显式转换类型，只有相同类型才会比较
    println(x.toLong() in listOf<Long>(1L, 2L, 3L))


    //字面值初始化已知类型的变量时，转换自动发生
    val b: Byte = 1
    //算数运算符被重载过，可以接收所有适当的数字类型
    val k = b + 1L

    //当字面值当做实参时，转换自动发送
    foo(42)
    //字符串转换为整数
    println("42".toInt())

    //Any是所有的超类，包括基本数据类型
    //Any区分可空Any?和不可空Any
    val answer: Any = 42

}


fun showProgress(progress: Int) {
    //对Int调用方法
    val percent = progress.coerceIn(0, 100)
    println("我们杀了${percent} 的人")
}

/**
 * 可空的基本数据类型
 */
data class UziNC(val name: String, val age: Int? = null) {
    fun isOlderThan(pOther: UziNC): Boolean? {
        if (age == null || pOther.age == null)
            return null
        return age > pOther.age
    }
}

fun foo(l: Long) = println(1)

//Unit相当于void Unit可以省略
fun f(): Unit {

}

fun f2() {

}

interface Processor<T> {
    fun process(): T
}

class NoResultProcessor : Processor<Unit> {
    //重写返回泛型参数的函数，没有返回值
    //自动默认加上了return Unit
    override fun process() {
    }

}

/**
 * Nothing永不返回的函数
 */
fun fail(message:String):Nothing{
    throw IllegalStateException(message)
}