package com.company.kotlin.clsobj

//不允许继承
class Goal{
}
//允许继承
open class Coal {
    //不允许重写
    fun fire() {
        println("fire")
    }

    //允许重写
    open fun click() {
        println("click")
    }
}
//允许继承
open class BlackCoal : Coal() {
    //允许重写
    override fun click() {
        super.click()
        println("black click")
    }
}
//允许继承
open class WhiteCoal : Coal() {
    //不允许重写
    final override fun click() {
        super.click()
        println("write click")
    }
}
