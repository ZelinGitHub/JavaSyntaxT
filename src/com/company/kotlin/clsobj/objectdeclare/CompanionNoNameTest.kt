package com.company.kotlin.clsobj.objectdeclare

class A {
    //没有名字的伴生对象
    companion object {
        fun bar() {
            print("companion object的bar方法被调用")
        }
    }
}

fun fuckCompanionNoName() {
    //使用默认对象名Companion，调用伴生对象函数，不需要伴生对象名
    A.Companion.bar();
    //通过容器类类名，调用伴生对象函数，不需要伴生对象名
    A.bar()
}