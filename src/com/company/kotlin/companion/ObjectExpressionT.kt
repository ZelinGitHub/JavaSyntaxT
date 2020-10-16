package com.company.kotlin.companion

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent


fun fuckHard() {
    val a = object {
        val name = "Adolf"
        val num = 678
    }
}

fun lickHard(){
    val b = object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            super.mouseClicked(e)
        }
    }
}