package com.company.kotlin.lambda

import java.lang.StringBuilder

/**
 * 输出字母表
 */
fun alphabet0(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nBalaBalaBala！")
    return result.toString()
}

fun alphabet1(): String {
    val stringBuilder = StringBuilder()
    //stringBuilder是接收者
    //参数1是接收者，参数2是lambda，lambda可以放在括号外面
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            //this访问接收者
            this.append(letter)
        }
        //this可以省略
        append("\nBalaBalaBala！")
        //lambda最后一个表达式是返回值
        this.toString()
    }
}

/**
 * 表达式函数体
 * with参数1是接收者，参数2是lambda
 */
fun alphabet2() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        //this访问接收者 可以省略
        append(letter)
    }
    append("\nBalaBalaBala！")
    toString()
}


/**
 * apply是扩展函数，参数是lambda，返回接收者对象，接收者是StringBuilder
 */
fun alphabet3() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        //this访问接收者 可以省略
        append(letter)
    }
    append("\nBalaBalaBala！")
}.toString()

fun alphabet4() = buildString {
    for (letter in 'A'..'Z') {
        //this访问接收者 可以省略
        append(letter)
    }
    append("\nBalaBalaBala！")
}