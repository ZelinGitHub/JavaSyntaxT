package com.company.kotlin.clsobj

/**
 *  抽象类
 *
 */
abstract class Animated{
    //抽象类中的抽象成员默认open
    abstract fun animate()

    //抽象类中的非抽象成员默认不是open
    open fun stopAnimating(){

    }

    //默认不是open
    fun animateTwice(){

    }
}