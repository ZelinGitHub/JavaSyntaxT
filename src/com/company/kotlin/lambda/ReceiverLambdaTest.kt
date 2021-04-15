package com.company.kotlin.lambda


fun defineFunTypeInitRun() {
    val a: (name: String) -> Unit = { name ->
        println("参数 $name")
    }
    a("fuck")
}

fun defineExtendFunTypeVar() {
    //定义扩展函数类型变量
    val lambdaWithReceiver: String.(name: String) -> Unit
}

fun initExtendFunTypeVar() {
    //使用lambda初始化这个扩展函数类型变量
    val lambdaWithReceiver: String.(name: String) -> Unit = { name ->
        //可以使用this引用接收者对象
        println("接收者 $this")
        println("参数 $name")
    }
}

fun runExtendFunTypeVar() {
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

//定义一个函数，参数类型是扩展函数类型
fun fuckExtendFunTypeParam(p: String.(name:String) -> Unit) {
    //使用String实例，调用扩展函数类型参数
    println("president".p("Hitler"))
    println(p("president","Hitler"))
}

//调用函数，传入lambda作为参数
fun fuckReceiverLambdaParam() {
    //参数传入lambda
    fuckExtendFunTypeParam {
        name->
        println(this)
        println(name)
    }
}