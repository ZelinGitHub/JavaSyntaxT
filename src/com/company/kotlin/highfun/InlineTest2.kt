package com.company.kotlin.highfun

import com.company.kotlin.lambda.Person


fun lpl() {
    val people = listOf<Person>(Person("无敌大厂长", 26), Person("逆风洗澡狗", 22))

    //filter是内联函数
    println(people.filter { it.age < 30 })
    //lambda表达式和成员引用
    println(people.filter { it.age > 30 }.map(Person::age))
}