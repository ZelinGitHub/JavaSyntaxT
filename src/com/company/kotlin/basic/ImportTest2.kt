package com.company.kotlin.basic
//导入Java类
import java.util.Random

class Rectangle3(val height:Int,val width:Int){
    //自定义访问器
    val isSquare:Boolean
        get()=height==width
}


fun createRandomRectangle(): Rectangle3 {
    //创建对象不需要new
    val random=Random()
    return Rectangle3(random.nextInt(), random.nextInt())
}