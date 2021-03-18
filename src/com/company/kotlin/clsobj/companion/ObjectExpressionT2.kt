package com.company.kotlin.clsobj.companion

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent


fun suckHard() {
    var a: Int = 0
    val b = object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            super.mouseClicked(e)
            a = 1;
        }
    }
}