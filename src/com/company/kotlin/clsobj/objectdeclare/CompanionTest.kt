package com.company.kotlin.clsobj.objectdeclare

import com.company.kotlin.basic.UziNC
import com.company.kotlin.clsobj.getFacebookName

//object对象声明
//companion定义伴生对象，可以省略类名
//伴生对象可以访问类内部的所有成员，包括private成员，包括private构造方法
//可以通过容器类名称来访问伴生对象的成员
class B {
    //有名字的伴生对象
    companion object She {
        fun bar() {
            print("companion object的bar方法被调用")
        }
    }
}


fun fuckCompanionNormal() {
    //使用伴生对象，调用伴生对象的函数
    B.She.bar()
    //通过容器类类名，调用伴生对象函数，不需要伴生对象名
    B.bar()
}







