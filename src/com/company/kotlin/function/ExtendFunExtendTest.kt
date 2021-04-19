package com.company.kotlin.function

open class Phone
fun Phone.call(){
    println("Phone call")
}
//Nokia继承了Phone的call方法
class Nokia:Phone()


interface Planet
fun Planet.expand(){
    println("Planet expand")
}
//Mars继承了Planet的expand方法
class Mars:Planet


fun testExtendFunExtend(){
    val nokia:Nokia=Nokia()
    val mars:Mars= Mars()

    nokia.call()
    mars.expand()
}

