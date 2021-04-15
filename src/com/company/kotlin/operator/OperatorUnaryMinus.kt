package com.company.kotlin.operator

/**
 * 重载一元运算符
 */
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}