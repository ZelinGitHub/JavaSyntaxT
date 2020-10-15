package com.company.kotlin.companion

import com.company.kotlin.basic.UziNC


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
