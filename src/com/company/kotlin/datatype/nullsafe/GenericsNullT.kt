package com.company.kotlin.datatype.nullsafe

/**
 * 泛型类和泛型函数的类型参数默认都是可空的
 * T推导出的类型是Any?
 */
fun<T> printlHashCode(t:T){
    println(t?.hashCode())
}

/**
 * 指定T的非空上界后，T就是不可空的了
 */
fun <T:Any> printHashCode(t:T){
    println(t.hashCode())
}