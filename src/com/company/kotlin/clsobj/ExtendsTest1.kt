package com.company.kotlin.clsobj


open class Animal(val nickname: String) {
}

open class ShenFu {
}

open class Ghost {
    constructor(name: String) {
    }

    constructor(name: String, number: String) {
    }
}

//当前类有主构造函数
//调用基类的主构造函数
class Tiger(nickname: String, id: String) : Animal(nickname) {
}

class Tiger3 : Animal("abc") {
}

//调用基类隐式的默认主构造函数
class Uzi constructor(name: String) : ShenFu() {
}

class Uzi3 : ShenFu() {
}

//调用基类的次构造函数
class BlackGhost(val mName: String) : Ghost("Davi", "007") {
}


//当前类没有主构造函数
//调用基类的主构造函数
class Tiger2 : Animal {
    private val mSex: Int

    constructor(sex: Int) : super("abc") {
        mSex = sex
    }
}

//调用基类隐式的默认主构造函数
class Uzi2 : ShenFu {
    private val mSex: Int

    constructor(pSex: Int) : super() {
        mSex = pSex
    }
}

//调用基类的次构造函数
class WhiteGhost : Ghost {
    private val mSex: Int;

    constructor(pSex: Int) : super("abc", "007") {
        mSex = pSex
    }
}

fun testExtendsTest1() {
    println(Tiger("Tom", "007"))
    println(Tiger3())

    println(Uzi("Jack"))
    println(Uzi3())

    println(BlackGhost("Alice"))

    println(Tiger2(0))
    println(Uzi2(0))
    println(WhiteGhost(1))
}