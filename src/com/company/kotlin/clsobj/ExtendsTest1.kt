package com.company.kotlin.clsobj



open class Animal(val nickname: String) {
}

//有主构造函数
class Tiger(nickname: String, id: String) : Animal(nickname) {
}

//有隐式生成的默认主构造函数
class Tiger3 : Animal("abc") {
}

//没有主构造函数
class Tiger2 : Animal {
    constructor(sex: String):super("abc") {

    }
}


open class ShenFu {
}

//有主构造函数
class Uzi constructor(name: String) : ShenFu() {
}
//有隐式生成的默认主构造函数
class Uzi3 : ShenFu() {
}

//没有主构造函数，只有一个次构造函数
class Uzi2 : ShenFu {
    constructor():super() {

    }
}



open class Ghost{
    constructor(name:String){

    }
    constructor(name:String,number:String){

    }
}

class BlackGhost: Ghost("Davi","007") {

}

