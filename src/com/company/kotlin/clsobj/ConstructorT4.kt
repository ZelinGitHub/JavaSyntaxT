package com.company.kotlin.clsobj

class Secret {

}

//私有化构造方法 类外部的代码无法实例这个对象
class Secretive private constructor(){

}

class Secretive2 {
    private constructor(){
    }
}

fun testConstructorT4(){

    Secret()

//    Secretive() //error
//    Secretive2() //error
}