package com.company.kotlin.lambda

fun testExtendMemberReferTest() {
    { str: String ->
        str.isDatui()
    }
    //扩展函数的成员引用
    val predicate = String::isDatui
}

fun String.isDatui() = length >= 21
