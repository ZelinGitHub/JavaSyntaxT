package com.company.kotlin.clsobj

//kotlin默认类是final不可继承的，open表示这个类可以被继承
open class RichButton : Clickable {

    //类方法默认是final的，不能被子类重写
    fun disable() {

    }

    //open方法可以被子类重写
    open fun animate() {

    }

    //重写了接口的函数，本身也是open的，可以置为final不是open禁止子类重写
    override fun click() {

    }

}

//可以置为final不是open禁止子类重写
open class RichButton2 : Clickable {
    override fun click() {
    }

}

open class RichButton3 : Clickable {
    final override fun click() {
    }
}