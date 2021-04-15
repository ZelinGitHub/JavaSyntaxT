package com.company.kotlin.operator

/**
 * 重载*运算符
 */
operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}


/**
 * 重载*运算符
 */
operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}