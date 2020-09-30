package com.company.kotlin.basic
//导入函数 需要包名和函数名，不需要文件名

fun main2(args:Array<String>){
    //可以导入函数 同一个包下面的不用导入就能用
    println(createRandomRectangle().isSquare)
}