package com.company.kotlin.operator

import java.lang.IndexOutOfBoundsException

//重载读取元素的下标运算符
class BlueDick(val x: Int, val y: Int) {
    operator fun get(index: Int): Int {
        return when (index) {
            0 -> x
            1 -> y
            else -> throw IndexOutOfBoundsException("无效索引 $index")
        }
    }
}

class RedDick(val x: Int, val y: Int)
//使用扩展函数，重载读取元素的下标运算符
operator fun RedDick.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("无效索引 $index")
    }
}

//重载写入元素的下标运算符
class MutableBlueDick(var x: Int, var y: Int) {
    operator fun set(index: Int, value: Int) {
        when (index) {
            0 -> x = value
            1 -> y = value
            else -> throw IndexOutOfBoundsException("无效索引 $index")
        }
    }
}

class MutableRedDick(var x: Int, var y: Int)
//使用扩展函数，重载写入元素的下标运算符
operator fun MutableRedDick.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("无效索引 $index")
    }
}


fun fuckGetSet(){
    val blueDick = BlueDick(10, 20)
    println(blueDick[1])

    val mutableBlueDick = MutableBlueDick(10, 20)
    //调用set方法
    mutableBlueDick[1] = 42;
    println(mutableBlueDick)

}