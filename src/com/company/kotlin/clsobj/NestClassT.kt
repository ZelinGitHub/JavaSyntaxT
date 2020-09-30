package com.company.kotlin.clsobj

import java.io.Serializable

interface  State:Serializable

interface View{
    //State是返回值类型
    fun getCurrentState():State
    fun restoreState(state: State){

    }
}

class Button3:View{
    override fun getCurrentState(): State =ButtonState()
    override fun restoreState(state: State) {
        super.restoreState(state)
    }
    //嵌套类 不存储外部类的引用
    class ButtonState:State
}

class Outer{
    //inner生命内部类
    inner class Inner{
        //得到外部类的引用
        //this@Outer外部类的引用
        fun getOuterReference():Outer=this@Outer
    }
}