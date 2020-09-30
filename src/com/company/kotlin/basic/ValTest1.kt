package com.company.kotlin.basic


//定义函数fun
// 参数是Array类型
// 泛型String
//Array类代替数组
fun main(args: Array<String>) {
    //final val
    //if else是表达式
    val name = if (args.size > 0) args[0] else "Kotlin"
    //静态函数println，取出final 值$
    println("Hello,$name")
    //成员函数size
    if (args.size > 0) {
        //大括号内部是表达式
        println("Hello,${args[0]}")
    }
    //双引号嵌套双引号
    //嵌套的双引号必须处于一个表达式的范围内，大括号括起来的是一个表达式的范围
    println("Hello,${if (args.size > 0) args[0] else "someone"})!")

    //创建对象 不需要new关键字
    //调用默认生成的构造函数
    val person2 = Person2("Bob", true)
    //直接引用属性，内部默认调用了get方法
    println(person2.name)
    println(person2.isMarried)
    println(max(1, 2))
    //直接引用属性，内部默认调用了set方法
    person2.isMarried = false;

    //不可变引用
    //创建对象不需要new
    val rectangle = Rectangle(41, 43)
    //调用自定义访问器
    println(rectangle.isSquare)
    //调用自定义访问器
    println(rectangle.isSquare2)
}

//新建类Person
//参数是final val
//这个类是值对象
//默认public class
//默认自带构造函数
class Person(val name: String)

//两个属性 注意是圆括号
//属性默认自带访访问器
//value只有get，var get set都有
class Person2(
        //final变量
        val name: String,
        //可变引用
        var isMarried: Boolean
)

//定义类
//两个属性 两个不可变引用 height和width
//矩形
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

//fun定义函数 返回值Int写到参数括号后面
//代码块函数体
fun max(a: Int, b: Int): Int {
    //if是表达式不是语句，表达式有值
    return if (a > b) a else b
}

//表达式函数体 代替大括号和return
fun max2(a: Int, b: Int): Int = if (a > b) a else b

//表达式函数体 省略函数类型
//表达式函数体系统会默认推导函数的返回值类型
fun max3(a: Int, b: Int) = if (a > b) a else b

//定义不可变引用  类型省略 默认int
val question = "中华民国总统府在台北还是南京？"
//定义不可变引用  类型省略 默认int
val answer = "南京"
//类型后置 默认字符串
val answer2: String = "重庆"
//默认int
val answer3 = 3
//默认Double
val yearsToCompute = 7.5e6


fun test() {
    //如果没有初始化，则必须给出类型
    val answer4: Int
    answer4 = 42

    //String 类型的不可变引用
    val message: String
    //只有唯一一次初始化可以执行
    if (canPerformOperation()) {
        message = "Success"
    } else {
        message = "Failed"
    }

    //不可变引用
    val languages = arrayListOf<String>("Java")
    //引用指向的对象可以变
    languages.add("Kotlin")
    languages.add("C++")
    languages.add("Basic")

    var answer = 42;
    //错误 var只可改值，不可改类型
//        answer="noswer"

}

private fun canPerformOperation(): Boolean {
    return true
}