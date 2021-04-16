package com.company.kotlin.operator

import java.math.BigDecimal
import java.time.LocalDate





fun testQT() {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)

    val p = Point(10, 20)
    //运算符重载不要求两个运算数是相同的类型
    println(p * 1.5)
    //and是位运算符与
    println(0x0F and 0xF0)
    //or是位运算符或
    println(0x0F or 0xF0)
    //带符号左移四位
    println(0x0F shl 4)


    var point = Point(1, 2)
    //复合赋值符运算符
    point += Point(3, 4)
    println(point)

    val numbers = ArrayList<Int>()
    //修改对象但是不分配引用
    numbers += 42
    println(numbers[0])


    val list = arrayListOf<Int>(1, 2)
    list += 3

    val newList = list + listOf<Int>(4, 5)

    val pxd = Point(10, 20)
    println(-pxd)

    var bd = BigDecimal.ZERO
    //调用重载过后的自加运算符
    println(bd++)
    println(++bd)

    val person1 = Mata("曼施坦因", "德国")
    val person2 = Mata("蒙哥马利", "英国")
    println(person1 < person2)

    //<内部调用compareTo
    println("abc" < "bac")
}

fun xyz() {


    val rect = Rectangle(Point(10, 20), Point(50, 50))
    //in 运算符将调用contains方法
    println(Point(20, 20) in rect)
    println(Point(5, 5) in rect)
    val now = LocalDate.now()
    //.. 约定为rangeTo
    val vacation = now..now.plusDays(10)
    //in 约定为contains
    println(now.plusWeeks(1) in vacation)

    val n = 9
    println(0..(n + 1))

    (0..n).forEach { print(it) }

    val newYear = LocalDate.ofYearDay(2017, 1)
    //..调用rangeTo
    val daysOff = newYear.minusDays(1)..newYear
    /**
     * 内部调用iterator函数 遍历区间
     */
    for (dayOff in daysOff) {
        println(dayOff)
    }
}
