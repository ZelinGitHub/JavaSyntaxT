package com.company.kotlin.clsobj.objectdeclare

import com.company.kotlin.basic.UziNC

//接口
interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

//伴生对象也可以实现接口
class Piglet(val name: String) {
    //未命名的伴生对象，实现了接口JSONFactory
    companion object : JSONFactory<UziNC> {
        //覆盖方法，必须有关键字override
        override fun fromJSON(jsonText: String): UziNC = UziNC("Tom")
    }
}


//参数是伴生对象实现的接口类型
fun <T> loadFromJSON(factory: JSONFactory<T>) {
    println(factory)
}



fun fuckCompanionInterface() {
    loadFromJSON(Piglet.Companion)
    //Person名字可以代替伴生对象的实例
    loadFromJSON(Piglet)
}