package com.company.kotlin.lambda


fun fuckNormalLambda() {
    val a: (name: String) -> Unit = { name ->
        println("参数 $name")
    }
    a("fuck")

}

fun fuckReceiverLambda() {
    //定义扩展函数类型变量
    //使用lambda初始化这个扩展函数类型变量
    val lambdaWithReceiver: String.(name: String) -> Unit = { name ->
        //可以使用this引用接收者对象
        println("接收者 $this")
        println("参数 $name")
    }
    //把实例作为第一个参数传入
    lambdaWithReceiver("suck", "fuck")
    //使用实例调用
    "lick".lambdaWithReceiver("fuck")
}


fun extendFuncTypeTest(p: String.(name:String) -> Unit) {
    //使用实例"good"，调用扩展函数类型参数
    println("president".p("Hitler"))
    println(p("president","Hitler"))
}


fun fuckReceiverLambdaParam() {
    //参数传入lambda
    extendFuncTypeTest {
        name->
        println(this)
        println(name)
    }
}