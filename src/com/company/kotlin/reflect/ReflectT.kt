package com.company.kotlin.reflect

import kotlin.reflect.KFunction2
import kotlin.reflect.KFunction1


fun test() {
    val person = Person("亢小雪", 26)
    //保存person对象的Person类的字节码
    val kClass = person.javaClass.kotlin
//输出类的简单名字 person
    println(kClass.simpleName)

    //foo是顶层函数
    //::foo成员引用，把函数转换成变量
    //kFunction是函数的字节码
    val kFunction = ::foo
    //调用函数
    //类的所有成员都是KCallable的实例，参数个数不确定不安全
    kFunction.call(42)

    //一个参数的函数的类型是kFunction1，Unit是返回值
    val kFunction1:KFunction1<Int,Unit> = ::foo
    //调用函数
    println(kFunction1.invoke(42))
    //直接调用字节码也可以
    println(kFunction1(42))

    //两个参数的函数的类型是kFunction2
    val  kFunction2: KFunction2<Int,Int,Int> =::sum
    println(kFunction2.invoke(1,2))
    println(kFunction2(1,2))

    //保存属性的字节码
    val kProperty=::counter
    kProperty.call(21)
    kProperty.setter.call(21)
    kProperty.set(21)
    println(kProperty.getter.call())
    println(kProperty.get())
}


class Person(val name: String, val age: Int)

fun foo(x: Int) = println(x)

fun sum(x:Int,y:Int)=x+y


var counter=0


