package com.company.kotlin.lambda

fun defineLambda(){
    {}
    {->}
    {->0}
    {x:Int->}
    {x:Int->0}
    { x: Int, y: Int ->}
    { x: Int, y: Int -> x + y }
}

fun runLambda() {
    //直接调用lambda表达式 用双括号()
    { x: Int, y: Int -> x + y }(2, 4)
    //调用run函数执行传递过来的lambda
    run {
        println(42)
    }
    //最后一个表达式就是lambda的结果
    println({ x: Int, y: Int ->
        println("计算出$x +$y 的结果是")
        x + y
    }(1, 2))
}


fun fuckFuncType() {
    //把lambda保存到变量 省略了声明变量类型
    val sum1 = { x: Int, y: Int -> x + y }
    val action1 = { println(42) }

    //变量具有函数类型，这个类型是(int,Int)->int
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    //没有参数和返回值，函数类型声明的Unit不能省略
    val action: () -> Unit = { println(42) }

    //函数类型返回值可空
    var canReturnNull: (Int, Int) -> Int? = { x, y -> null }

    //函数类型的可空变量
    val funOrNull: ((Int, Int) -> Int)? = null

}

fun executeFuckTypeVar() {
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    sum(1, 2)
    val sum2: ((Int, Int) -> Int)? = null
    sum2?.invoke(1, 2)
}

