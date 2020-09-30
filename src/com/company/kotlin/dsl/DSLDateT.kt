package com.company.kotlin.dsl

import java.time.LocalDate
import java.time.Period

/**
 * 为基本数据类型定义扩展属性
 * 扩展属性必须定义get字段
 */
val Int.days: Period
    get() = Period.ofDays(this)

/**
 * 为Period定义扩展属性ago
 * 扩展属性必须定义get字段
 */
val Period.ago: LocalDate
    get() = LocalDate.now() - this

/**
 * 为Period定义扩展属性fromNow
 * 扩展属性必须定义get字段
 */
val Period.fromNow:LocalDate
    get()= LocalDate.now()+this


fun jiandenglong(){
    //基本数据类型1调用扩展属性
    println(1.days.ago)
    println(1.days.fromNow)
}