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

val question = "fk ur mtr？"
val answer = "Y"
val answer2: String = "Good"
val answer3 = 3
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