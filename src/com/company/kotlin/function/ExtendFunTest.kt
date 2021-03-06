package com.company.kotlin.function

/**
 * 扩展函数
 * 扩展函数是类的一个成员函数 定义在类的外面
 * this指向被扩展的类Sting的对象
 * lastChar是类外的String的成员函数
 * 被扩展的类是接收者类型，调用函数的对象是接收者对象，两个this都是接收者对象
 */
fun String.lastChar(): Char = this.get(this.length - 1)


//this可以省略
//扩展函数可以访问类的成员
//扩展函数不能访问类的私有成员
fun String.lastChar2(): Char = get(length - 1)



val c="Kotlin".lastChar()

val ccc="4396瞎子之王".lastChar()

fun testLastChar() {
    //调用扩展函数
    //"Hello America!"是接收者对象
    //String是接收者类型
    print("Hello America!".lastChar())
}
