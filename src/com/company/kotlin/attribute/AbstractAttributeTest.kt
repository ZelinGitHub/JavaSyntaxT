package com.company.kotlin.attribute

interface Chimpanzee {
    //抽象属性
    abstract val nickname: String
    abstract var workId: Int
}

abstract class Horse {
    abstract val nickname: String
    abstract var workId: Int
}

//使用了简洁的语法，直接在主构造方法中声明了一个属性
//这个属性实现了来自于User 的抽象属性，所以将其标记为override
class PrivateUser(override val nickname: String, override var workId: Int)
    : Chimpanzee

class SbUser() : Chimpanzee {
    //自定义getter ，没有支持字段来存储值
    override val nickname: String
        get() = "tom"
    //自定义getter和setter，没有支持字段来存储值
    override var workId: Int
        get() = 1
        set(value) {
            println("设置workId $value")
        }
}

class SubscribingUser() : Chimpanzee {
    //自定义getter，有支持字段来存储值
    override val nickname: String="Jack"
        get() {
            return "$field Mr"
        }
    //自定义getter和setter，有支持字段来存储值
    override var workId: Int = 1
        get() = 1
        set(value) {
            field = value
            println("设置workId $field")
        }
}

class FaceBookUser() : Chimpanzee {
    //使用默认的getter和setter，有支持字段来存储值
    override val nickname = "tom"
    override var workId: Int = 1
}
