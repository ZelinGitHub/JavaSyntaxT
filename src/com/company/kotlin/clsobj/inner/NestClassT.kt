package com.company.kotlin.clsobj.inner

import java.io.Serializable

interface  State:Serializable

interface View{
    //State是返回值类型
    fun getCurrentState(): State
    fun restoreState(state: State){
    }
}

class Button3: View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {
        super.restoreState(state)
    }
    //嵌套类 不存储外部类的引用
    class ButtonState: State
}

