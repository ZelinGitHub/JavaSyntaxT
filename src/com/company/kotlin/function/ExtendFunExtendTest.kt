package com.company.kotlin.function

open class Phone{

}

fun Phone.call(){
    println("Phone call")
}

class Nokia:Phone(){

}

fun testExtendFunExtend(){
    val nokia:Nokia=Nokia()
    nokia.call()
}