package com.company.kotlin.attribute

open class Face() {
    open val name: String = "Mike"
    open var isMarried: Boolean = false
}

class WriteFace : Face() {
    override val name: String = "Jack"
    override var isMarried: Boolean = false
}

class BlackFace : Face() {
    override var name: String = "Jinx"
    override var isMarried: Boolean = false
}

class RedFace : Face() {
    override val name: String
        get() {
            return "Tom"
        }
    override var isMarried: Boolean
        get() {
            return false
        }
        set(value) {
            println(value)
        }
}

class BlueFace : Face() {
    override val name: String = "Tom"
        get() {
            return "$field Mr"
        }
    override var isMarried: Boolean = false
        get() {
            return field
        }
        set(value) {
            println(field)
        }
}


class BigAss {
    val name: String = "Mike"
    var isMarried: Boolean = false
}

class Lob {
    val name: String
        get() {
            return "tom"
        }
    var sex: String
        get() {
            return "man"
        }
        set(value) {
            println(value)
        }
}

//自定义getter，
class Rectangle() {
    //使用默认getter，具有支持字段，必须初始化
    val isBeauty: Boolean = false


    //自定义getter，不使用field，没有支持字段，不能初始化
    val isSquare: Boolean
        get() {
            return true
        }

    //自定义getter，使用field，具有支持字段，必须初始化
    val isGood: Boolean = false
        get() {
            return field
        }
}


//自定义getter和setter
class Boss() {
    //使用默认setter
    //具有支持字段，必须初始化
    var color: String = "红色"

    //使用默认setter
    //具有支持字段，必须初始化
    var energy: String = "huge"
        get() {
            return "地址改变"
        }

    //使用默认getter
    //具有支持字段，必须初始化
    var address: String = "火星"
        set(value: String) {
            println("地址改变")
        }


    //自定义getter和setter，getter和setter都使用field
    //具有支持字段，必须初始化
    var sex: String = ""
        get() {
            return field + "man"
        }
        set(value) {
            println("设置新的性别")
            field = value
        }

    //自定义getter和setter，getter使用field，setter没有使用field
    //具有支持字段，必须初始化
    var age: String = "2"
        get() {
            return field + "100"
        }
        set(value) {
            println("设置新的名字 $value")
        }

    //自定义getter和setter，setter使用field，getter没有使用field
    //具有支持字段，必须初始化
    var name: String = ""
        get() {
            return "Jack"
        }
        set(value) {
            println("设置新的名字")
            field = value
        }


    //自定义getter和setter，不使用field
    //没有支持字段，不能初始化
    var nation: String
        get() {
            return "China"
        }
        set(value) {
            println(value)
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

    val rectangle = Rectangle()
    //使用自定义访问器
    println(rectangle.isSquare)
}
