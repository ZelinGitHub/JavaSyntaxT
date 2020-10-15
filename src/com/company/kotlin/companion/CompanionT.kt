package com.company.kotlin.companion

import com.company.kotlin.basic.UziNC
import com.company.kotlin.clsobj.getFacebookName

class A {
    //object对象声明
    //companion定义伴生对象，可以省略类名
    //伴生对象可以访问类内部的所有成员，包括private成员，包括private构造方法
    //可以通过容器类名称来访问伴生对象的成员
    companion object {
        fun bar() {
            print("companion object的bar方法被调用")
        }
    }
}

fun companionTest() {
    //通过容器类类名调用伴生对象函数，不需要伴生对象名
    A.bar()
}
