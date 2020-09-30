package com.company.kotlin.lambda

import com.company.kotlin.lambda.Europa.postponeComputation


fun btns(){
    //把lambda当做Runnable对象传过去
    postponeComputation(/*delay*/1000)/*Runnable*/{ println(42)}

    //实现Runnable的匿名对象
    postponeComputation(1000,object :Runnable{
        override fun run() {
            println(42)
        }
    })

    //创建Runnable对象，参数是lambda
    val runnable= Runnable { println(42) }
    fun handleComputation(){
        //等价于直接传递lambda
        postponeComputation(1000,runnable)
    }
}

