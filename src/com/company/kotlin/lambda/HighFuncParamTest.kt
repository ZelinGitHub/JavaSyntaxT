package com.company.kotlin.lambda

import java.lang.StringBuilder





fun processTheAnswer(f:(Int)->Int){
    //调用lambda
    println(f(42))
}

/**
 * 参数是一个lambda，传递一个函数进入
 */
fun twoAndThree(operation:(Int,Int)->Int){
    //调用参数，参数是函数类型
    val result=operation(2,3)
    println("结果是$result")
}

/**
 * 参数2是函数类型
 */
fun performRequest(url:String,callback:(code:Int,content:String)->Unit){
    println(url)
}

//l函数类型参数可空
fun foo(callback:(()->Unit)?){
    if(callback!=null){
        callback()
    }
    callback?.invoke()
}

fun testHighFuncParamTest(){
    val url="http://kotl.in"
    //参数2是一个lambda，可以放到外面
    performRequest(url){code,content-> println(content)}
    //改变函数类型的参数名称
    performRequest(url){code,page-> println(page)}

    //调用函数，传递一个lambda
    twoAndThree{a,b->a+b}
    //调用函数，传递一个lambda
    twoAndThree{a,b->a*b}

    //filter函数传递一个lambda，是筛选条件
    println("aabb333344cccdddeee99xxzz".filter { it in 'a'..'z' })
}

