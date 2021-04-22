package com.company.kotlin.clsobj.companion

class Mouth {
    companion object Teeth {
        var num = 0;

        init {
            num = 14;
        }
    }
}

public fun testCompanionInit() {
    println(Mouth.Teeth.num)
}