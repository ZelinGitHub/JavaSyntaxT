package com.company.kotlin.clsobj.companion


class B {
    companion object She {
        fun bar() {
            print("companion object的bar方法被调用")
        }
    }
}

fun companionTest1() {
    B.She.bar()
    B.bar()
}
