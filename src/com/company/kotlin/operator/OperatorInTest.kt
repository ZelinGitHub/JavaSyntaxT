package com.company.kotlin.operator




data class Rectangle(val upperLeft: Point, val lowerRight: Point)


/*
in运算符约定为contains方法
 */
operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x
            &&
            p.y in upperLeft.y until lowerRight.y
}