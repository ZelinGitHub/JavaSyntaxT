package com.company.kotlin.companion

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent


fun fuckHard() {
    object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            super.mouseClicked(e)
        }
    }
}