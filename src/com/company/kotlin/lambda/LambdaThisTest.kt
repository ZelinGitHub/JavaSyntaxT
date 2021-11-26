package com.company.kotlin.lambda



class BOP {
    fun fuck() {
        println("函数fuck $this")
        val lambda1 = {
            println("lambda1 $this")
            val lambda2 = {
                println("lambda2 $this")
            }
            lambda2()
        }
        lambda1()
    }
}

