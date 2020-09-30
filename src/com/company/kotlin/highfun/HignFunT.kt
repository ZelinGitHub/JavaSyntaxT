package com.company.kotlin.highfun

import java.lang.StringBuilder

fun Yer(){
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

/**
 * 参数2是函数类型，参数值是一个lambda表达式，lambda表达式的类型就是函数类型
 */
fun performRequest(url:String,callback:(code:Int,content:String)->Unit){

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
 * 扩展函数，参数lambda，lambda参数是Char，返回Boolean
 */
fun String.filter(predicate:(Char)->Boolean):String{
    val sb=StringBuilder()
    for(index in 0 until  length){
        val element=get(index)
        //如果是想要的元素，predicate是lambda
        if(predicate(element)){
            sb.append(element)
        }
    }
    return  sb.toString()
}

fun processTheAnswer(f:(Int)->Int){
    //调用lambda
    println(f(42))
}