package com.company.kotlin.dsl

import java.lang.StringBuilder

/**
 * 参数是一个lambda
 * 高阶函数
 */
fun buildString1(
        builderAction: (StringBuilder) -> Unit
): String {
    val sb = StringBuilder()
    //调用参数的lambda
    builderAction(sb)
    return sb.toString()
}


fun test() {
    //参数传入lambda
    val s1 = buildString1 {
        it.append("fuck")
        it.append("you")
    }
    println(s1)
    //参数传入一个lambda
    // 带接收者的lambda
    val s2 = buildString2 {
        this.append("mother")
        append("fucker")
    }
    println(s2)

    //把扩展函数类型的lambda保存到变量
    val appendExcl:StringBuilder.()->Unit={this.append("kkoma")}
    val stringBuilder=StringBuilder("江泽民")
    //像调用扩展函数一样调用lambda保存的变量
    stringBuilder.appendExcl()
    println(stringBuilder)
    //可以把这个保存lambda的变量当做参数传递
    println(buildString2(appendExcl))

    //可编辑的map
    val map= mutableMapOf(1 to "dick")
    //with和apply是接收者用来调用lambda的
    //apply是接收者的扩展函数，返回接收者本身
    map.apply { this[2]="pussy" }
    //with把接收者当做第一个参数，返回lambda调用后的结果
    with(map){this[3]="breast"}
    println(map)
}

/**
 * 参数是一个lambda
 * 这个lambda是扩展函数的形式，参数为空，返回空
 * 调用lambda也是扩展函数的形式
 */
fun buildString2(builderAction: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    //调用lambda sb是接收者
    sb.builderAction()
    return sb.toString()
}

