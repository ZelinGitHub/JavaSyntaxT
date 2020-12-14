package com.company.kotlin.func

fun joinToString(name: String): String {
    println("Kick his ass")
    return name
}


fun testTopFunTest() {
    joinToString("Mary")
}

fun double(x: Int): Int {
    return 2 * x
}

fun fuckABC(str: String) {
    //str = "abc" //这句代码将报错
    println(str)
}

fun powerOf(number: Int, exponent: Int) {
    println("number:$number exponent:$exponent")
}