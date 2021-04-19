package com.company.kotlin.function

//参数off具有默认值0
//参数len具有默认值b.size
fun sillyFuck(b: Array<Byte>, off: Int = 0, len: Int = b.size) {
    println("fuck u $b $off $len")
}

fun fuckSilly() {
    sillyFuck(arrayOf(1, 2, 3), 1, 3)
    sillyFuck(arrayOf(1, 2, 3), 1)
    sillyFuck(arrayOf(1, 2, 3))
}

open class SillyA {
    open fun foo(i: Int = 10) {
    }
}

class SillyB : SillyA() {
    override fun foo(i: Int) { // 不能有默认值
    }
}

@JvmOverloads
fun sillyLick(a: String, b: Int = 0, c: String = "abc") {
    println("$a $b $c")
}
