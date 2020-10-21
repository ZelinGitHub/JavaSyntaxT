package com.company.kotlin.clsobj


class Rectangle(val height: Int, val width: Int) {
    //自定义访问器 这个isSquare是属性但不是类的字段
    val isSquare: Boolean
        get() {
            return height == width
        }

    //用表达式代替代码块
    val isSquare2: Boolean
        get() = height == width

}

fun testAttributeT2() {
    val rectangle = Rectangle(41, 43)
    //使用自定义访问器
    println(rectangle.isSquare)
    //使用自定义访问器
    println(rectangle.isSquare2)
}