package com.company.kotlin.lambda



//顶层函数
fun salute() = println("Salute")

fun fuck(age:Int,message: String) {
    println("sb")
}

fun testMemberReferTest2(){

    //引用顶层函数，省略类名
    run(::salute)



    //lambda保存到变量
    val action = {
        //lambda参数
        age: Int, message: String ->
        //lambda函数体，调用了顶层函数
        fuck(age,message)
    }

    //这个顶层函数的成员引用等价于上面的lambda
    val nextAction = ::fuck
}