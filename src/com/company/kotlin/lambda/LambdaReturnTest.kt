package com.company.kotlin.lambda

import java.lang.StringBuilder

data class LiveStock(val name: String, val age: Int)

val people = listOf<LiveStock>(LiveStock("Doctor Xi", 33), LiveStock("Pig", 11))


fun lookForSb(liveStock: List<LiveStock>) {
    liveStock.forEach {
        if (it.name == "Doctor Xi") {
            println("Shoot")
            //return将退出forEach函数而不是lambda
            //只有内联函数可以在lambda中返回自己
            return
        }
    }
    println("no found")
}


fun lookFor2b(people: List<LiveStock>) {
    //传递一个lambda
    people.forEach label@{
        if (it.name == "Doctor Xi") {
            println("Cut")
            //使用标签退出lambda而不是退出外面的函数
            return@label
        }
    }
    println("no found")
}

fun lookForDog(people: List<LiveStock>) {
    people.forEach {
        if (it.name == "Doctor Xi") {
            println("Kill")
            //使用return lambda参数所在的函数名 退出lambda
            return@forEach
        }
    }
    println("no found")
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