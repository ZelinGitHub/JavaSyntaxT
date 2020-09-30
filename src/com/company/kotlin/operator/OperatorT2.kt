package com.company.kotlin.operator

import java.lang.IndexOutOfBoundsException
import java.time.LocalDate


fun xyz() {
    val p = Point(10, 20)
    println(p[1])

    val mutablePoint = MutablePoint(10, 20)
    //调用set方法
    mutablePoint[1] = 42;
    println(mutablePoint)


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

    val newYear=LocalDate.ofYearDay(2017,1)
    //..调用rangeTo
    val daysOff=newYear.minusDays(1)..newYear
    /**
     * 内部调用iterator函数 遍历区间
     */
    for(dayOff in daysOff){
        println(dayOff)
    }
}

/**
 * 下标运算符[]取元素和写入元素分别约定为get函数和set函数
 * 重写get和set函数，就是重写[]
 */
operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("无效索引 $index")
    }
}


data class MutablePoint(var x: Int, var y: Int)

/**
 * 扩展函数重载set函数，约定为[]
 */
operator fun MutablePoint.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("无效索引 $index")
    }
}


data class Rectangle(val upperLeft: Point, val lowerRight: Point)


/*
in运算符约定为contains方法
 */
operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x
            &&
            p.y in upperLeft.y until lowerRight.y
}


/**
 * for(x in list){}结构约定为iterator
 */
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        //object定义匿名对象
        //使用Sam构造方法，大括号里面是一个lambda
        object : Iterator<LocalDate> {
            var current = start
            override fun hasNext(): Boolean =
                    current <= endInclusive

            /**
             * apply函数，接收者是current，参数是lambda
             */
            override fun next()=current.apply{
                //当前日期增加一天
                current=plusDays(1)
            }

        }
