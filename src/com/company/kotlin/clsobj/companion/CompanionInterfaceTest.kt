package com.company.kotlin.clsobj.companion

interface Animal {
    companion object Head {
        fun explode() {
            println("Animal companion Head explode")
        }
    }
}

interface Plant {
    companion object {
        fun extend() {
            println("Plant companion extend")
        }
    }
}