package com.company.kotlin.lambda

fun testLambdaTest() {

    { x: String -> println(x) }


    //把lambda存储到变量里
    //参数x y 函数体 x+y
    //lambda存储到变量里，可以把变量当做普通函数对待
    val sum = { x: Int, y: Int -> x + y }
    //直接调用lambda表达式 用双括号()
    { x: Int, y: Int -> x + y }(2, 4)
    sum(2, 4)

    //run函数执行传递过来的lambda
    run { println(42) }


    //最后一个表达式就是lambda的结果
    val xiZaoGou = { x: Int, y: Int ->
        println("计算出$x +$y 的结果是")
        x + y
    }
    println(xiZaoGou(1, 2))


}