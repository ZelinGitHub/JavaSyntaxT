package com.company.kotlin.basic

//枚举类 软关键字enum
enum class Color {
    //实际上是类对象
    RED,
    ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

//枚举类也可以定义属性
enum class Color2(val r: Int, val g: Int, val b: Int) {
    //枚举值实际上是类对象
    //传入三个构造函数参数
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    //枚举定义方法后，必须用分号把方法和枚举值分开
    VIOLET(238, 130, 238);

    //枚举也可以定义方法
    //表达式方法体可以胜率方法类型
    fun rgb() = (r * 256 + g) * 256 + b

}

//表达式方法体
//省略函数类型
fun getMnemonic(color2: Color2)
//when代替switch
//when是表达式 有返回值
//多行表达式函数体
//when不需要写break
        = when (color2) {
    Color2.RED -> "血"
    Color2.BLUE -> "大海"
    Color2.ORANGE -> "橘子"
    Color2.YELLOW -> "沙漠"
    Color2.GREEN -> "草"
    Color2.INDIGO -> "天空"
    Color2.VIOLET -> "紫罗兰"
}

fun testOOO() {
    println(getMnemonic(Color2.BLUE))
}


//一个分支可以有多个条件
fun getWarmth(color2: Color2) = when (color2) {
    Color2.RED, Color2.ORANGE, Color2.YELLOW -> "fuck"
    Color2.BLUE, Color2.INDIGO, Color2.VIOLET -> "love"
    Color2.GREEN -> "die"

}