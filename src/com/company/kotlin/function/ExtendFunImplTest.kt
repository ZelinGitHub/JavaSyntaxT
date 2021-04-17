package com.company.kotlin.function


interface Planet{

}

fun Planet.expand(){
    println("Planet expand")
}

class Mars:Planet{

}

fun testExtendFunImpl(){
    val mars:Mars= Mars()
    mars.expand()
}