package com.company.kotlin.lambda


fun createSAM() {
    val runnable = Runnable {
        println("Brazil")
    }
}

fun samParam() {
    //传递给Java方法
    Thread(
            Runnable { println("Europe") }
    )
    //传递给Kotlin函数
    killByOx(Runnable {
        println("TTT")
    })
}

fun returnSAM(): Runnable {
    return Runnable {
        println("SSS")
    }
}

fun killByOx(pRunnable: Runnable) {
    pRunnable.run()
}

fun invokeKotlinSAMParamFunc() {
    //    killByOx{ //调用Kotlin函数时，Java函数式接口类型的参数，不能简化为一个lambda
//        println("EEE")
//    }
}

//调用Java方法时，Java函数式接口类型的参数，可以简化为一个lambda
fun invokeJavaSAMParamFunc() {
    Thread {
        println("Japan")
    }
}