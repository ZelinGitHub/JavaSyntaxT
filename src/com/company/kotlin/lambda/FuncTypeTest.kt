package com.company.kotlin.lambda

fun  testFuncTypeTest(){
    //把lambda保存到变量 省略了声明变量类型
    val sum1={x:Int,y:Int->x+y}
    val action1={ println(42)}

    //变量具有函数类型，这个类型是(int,Int)->int
    val sum:(Int,Int)->Int={x,y->x+y}
    //没有参数和返回值，函数类型声明的Unit不能省略
    val action:()->Unit={ println(42)}

    //函数类型返回值可空
    var canResurnNull:(Int,Int) -> Int?={x,y->null}

    //函数类型的可空变量
    var funOrNull:((Int,Int)->Int)?=null
}