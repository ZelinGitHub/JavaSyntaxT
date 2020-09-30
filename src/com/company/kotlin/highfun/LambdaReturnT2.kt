package com.company.kotlin.highfun

import java.lang.StringBuilder


fun lookFor2b(people: List<Person>) {
    //传递一个lambda
    people.forEach label@{
        if (it.name == "习包子") {
            println("枪毙")
            //使用标签推出lambda而不是推出外面的函数
            return@label
        }
    }
    println("没有找着傻逼")
}

fun lookForDog(people: List<Person>) {
    //传递一个lambda
    people.forEach {
        if (it.name == "习包子") {
            println("枪毙")
            //使用return lambda参数的函数名 退出lambda
            return@forEach
        }
    }
    println("没有找着傻逼")
}

fun gcgd(){
    //两层apply
    println(StringBuilder().apply sb@{
        listOf<Int>(1,2,3).apply {
            //使用标签访问外层的接收者，这个this是内层的接收者
            this@sb.append(this.toString())
        }
    })
}