package com.company.kotlin.attribute

var opCount = 0

val UNIX_LINE_SEPARATOR = "\n"

var chilly=""



fun performOperation() {
    opCount++
}

fun reportOperationCount() {
    println("操作执行了 $opCount 次")
}


