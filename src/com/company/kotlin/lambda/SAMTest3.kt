package com.company.kotlin.lambda

fun testSAMTest3(){


    killByOx(Runnable {
        println("TTT")
    })

//    killByOx{ //调用Kotlin函数时，Java函数式接口类型的参数，不能简化为一个lambda
//        println("EEE")
//    }


    val runnable:Runnable= Runnable { println("Europe") }
    Thread(runnable)

    Thread(Runnable { println("Europe") })

    //调用Java方法时，Java函数式接口类型的参数，可以简化为一个lambda
    Thread{
        println("Japan")
    }


}


fun killByOx(pRunnable: Runnable) {
    pRunnable.run()
}