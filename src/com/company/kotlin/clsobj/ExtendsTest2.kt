package com.company.kotlin.clsobj


open class Coal {
    fun fire() {
        println("fire")
    }

    open fun click() {
        println("click")
    }
}

open class BlackCoal : Coal() {
    override fun click() {
        super.click()
        println("black click")
    }
}

open class WhiteCoal : Coal() {
    final override fun click() {
        super.click()
        println("write click")
    }
}
