package com.company.kotlin.attribute


class Rectangle(val height: Int, val width: Int) {
    //自定义get方法
    val isSquare: Boolean
        get() {
            return height == width
        }
}

class Boss(){
    var name: String = ""
        get() {
            return "Jack"
        }
        set(value) {
            field = value
        }
}

fun testAttributeTest2() {
    val rectangle = Rectangle(41, 43)
    //使用自定义访问器
    println(rectangle.isSquare)
}


class LengthCounter {
    //修改默认访问器的可见性
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}


class Gorilla(val name: String) {
    var address: String = "火星"
        set(value: String) {
            print("""$name 的地址改变："$field"->"$value"。""".trimIndent())
            field = value
        }
}