package com.company.kotlin.operator

data class Point(val x: Int, val y: Int) {
    /**
     *  plus约定为+
     *  重载+运算符
     */
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

}


/**
 *  运算符重载也可以是扩展函数
 */
operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}
