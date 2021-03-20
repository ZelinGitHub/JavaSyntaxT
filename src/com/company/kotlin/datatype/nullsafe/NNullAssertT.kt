package com.company.kotlin.datatype.nullsafe

fun ignoreNulls(s:String?){
    //!!把任何值转换成非空类型
    //如果s为空，抛出异常
    val sNotNull:String=s!!
    println(sNotNull.length)
}