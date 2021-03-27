package com.company.kotlin.clsobj.objectexpression

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

//使用对象表达式为顶层变量赋值
val ass = object {
    val name = "big"
}

//使用对象表达式为属性赋值
class Peanut {
    val a = object {
        val name = "Adolf"
        val num = 678
    }
}

//使用对象表达式为局部变量赋值
fun fuckHard() {
    val a = object {
        val name = "Adolf"
        val num = 678
    }
}

//返回对象表达式
private fun changeColor(): Any {
    return object {
        private val a = "abc"
    }
}

//返回对象表达式
private fun changeLength(): MouseAdapter {
    return object : MouseAdapter() {
        private val a = "abc"
    }
}

//返回对象表达式
private fun changeSize() = object {
    private val a = "abc"
}



//父类
open class March {
}

//父类
open class April(private val name: String?, private val age: Int) {
}

//抽象类
abstract class July() {
    abstract fun tight();
}

//接口
interface May {
    fun fight();
}

//调用父类无参构造函数
val march = object : March() {
}

//调用父类具参构造函数
val april = object : April("Jack", 33) {
}

//继承一个抽象类
//调用抽象类的构造函数
//实现抽象方法
val july = object : July() {
    override fun tight() {
        println("tight")
    }
}

//实现一个接口
//实现抽象方法
val may = object : May {
    override fun fight() {
        println("fight")
    }
}


fun suckHard() {
    var a: Int = 0
    val b = object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            super.mouseClicked(e)
            a = 1;
        }
    }
}

class Tree {
    //私有类型，所以变量类型是匿名对象的类型
    private val a = object {
        val x: String = "x"
    }

    //公有类型，所以变量类型是 Any
    public val b = object {
        val x: String = "x"
    }

    //私有类型，所以返回类型是匿名对象的类型
    private fun fool() = object {
        val x: String = "x"
    }

    //公有类型，所以返回类型是Any
    public fun tool() = object {
        val x: String = "x"
    }

    fun bar() {
        // 没问题
        val x1 = a.x
        //错误：未能解析的引用“x”
//        val x2 = b.x
        //没问题
        val x3 = fool().x
        //错误：未能解析的引用“x”
//        val x4 = tool().x
    }

}
