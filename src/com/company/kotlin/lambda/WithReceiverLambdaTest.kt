package com.company.kotlin.lambda

fun testWithReceiverLambdaTest(){
    val a:(name:String)->Unit={
        name->
        println("参数 $name")
    }
    val b:Int=0

    val lambdaWithReceiver:String.(name:String)->Unit={
        name ->
        println("接收者 $this")
        println("参数 $name")
    }

    a("fuck")
    lambdaWithReceiver("suck","fuck")
    "lick".lambdaWithReceiver("fuck")

    extendFuncTypeTest {
        println(this)
    }
}

fun extendFuncTypeTest(p:String.()->Unit){
    println("good".p())
}