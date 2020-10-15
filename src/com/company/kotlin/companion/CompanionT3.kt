package com.company.kotlin.companion


class PersonX(val firstName:String,val lastName:String){
    //空伴生对象，未命名
    //默认名字是Companion
    companion object {

    }
}

/**
 * 给伴生对象定义扩展函数
 * 省略伴生对象名字的伴生对象默认名字是Companion，定义扩展函数也用这个
 */
fun PersonX.Companion.fromJSON(json:String): PersonX {
    return PersonX("习明泽", "彭母猪")
}

fun testCompanionT3(){

    //用容器类类名调用伴生对象的扩展函数
    val pX= PersonX.fromJSON("{name:'Jinx'")
}