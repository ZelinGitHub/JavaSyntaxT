package com.company.kotlin.highfun

data class Person(val name: String, val age: Int)

val people = listOf<Person>(Person("习包子", 33), Person("习猪头", 11))


fun lookForSb(people: List<Person>) {
    //传递一个lambda
    people.forEach {
        if (it.name == "习包子") {
            println("枪毙")
            //return将推出forEach函数而不是lambda
            //只有内联函数可以在lambda中返回自己
            return
        }
    }
    println("没有找着傻逼")
}