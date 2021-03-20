package com.company.kotlin.attribute


class BigAss {
    val name: String = "Mike"
    var isMarried: Boolean = false
}

//自定义getter
class Rectangle(val height: Int, val width: Int) {
    //自定义get方法
    val isSquare: Boolean
        get() {
            return height == width
        }
}

//自定义setter
class Gorilla(val name: String) {
    var address: String = "火星"
        set(value: String) {
            print("""$name 的地址改变："$field"->"$value"。""".trimIndent())
            field = value
        }
}

//自定义getter和setter
class Boss() {
    var name: String = ""
        get() {
            return "Jack"
        }
        set(value) {
            println("设置新的名字")
            field = value
        }
}


//修改默认访问器的可见性
class LengthCounter {
    //修改默认访问器的可见性
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}


fun test() {
    val bigAss = BigAss()
    //引用属性，内部默认调用了set方法
    bigAss.isMarried = false;
    //引用属性，内部默认调用了get方法
    println(bigAss.name)
    println(bigAss.isMarried)

    val rectangle = Rectangle(41, 43)
    //使用自定义访问器
    println(rectangle.isSquare)
}
