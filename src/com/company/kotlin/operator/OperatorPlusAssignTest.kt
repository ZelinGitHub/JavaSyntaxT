package com.company.kotlin.operator

/**
 * 重载+=运算符  +=约定为plusAssign
 */
operator fun<T> MutableCollection<T>.plusAssign(element:T){
    this.add(element)
}