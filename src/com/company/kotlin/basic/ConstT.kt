//改变默认生成的Java类名 本来应该是ConstKt
@file:JvmName("StringFunctions")

package com.company.kotlin.basic

//顶层属性 就是静态字段
//顶层属性也是通过get和set暴露给java的
var opCount = 0
val UNIX_LINE_SEPARATOR = "\n"

//顶层函数
fun performOperation() {
    opCount++;
}

//用顶层属性来统计函数执行的次数
fun reportOperationCount() {
    print("函数执行了$opCount 次")
}

//等价于public static final（Java语法）
const val Unix_line_sep = "\n"