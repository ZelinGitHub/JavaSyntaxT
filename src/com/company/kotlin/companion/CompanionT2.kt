package com.company.kotlin.companion

import com.company.kotlin.basic.UziNC

/*
伴生对象也可以实现接口
 */
interface JSONFactory<T>{
    fun fromJSON(jsonText: String):T
}


class Person(val name:String){
    //未命名的伴生对象，实现了接口JSONFactory
    companion object: JSONFactory<UziNC> {
        //覆盖方法，必须有关键字override
        override fun fromJSON(jsonText :String): UziNC = UziNC("蔡包子")
    }
}

fun testCompanionT2(){

    //person名字可以代替伴生对象的实例
    loadFromJSON(Person)
}