package com.company.kotlin.clsobj.companion


class Zebra() {
    companion object Dick {
    }
}

class Monkey() {
    //空伴生对象，未命名
    //默认名字是Companion
    companion object {
    }
}

fun Zebra.Dick.fuck() {
    println("zebra extend fun")
}


//给伴生对象定义扩展函数
//省略伴生对象名字的伴生对象默认名字是Companion，定义扩展函数也用这个
fun Monkey.Companion.fuck() {
    println("monkey extend fun")
}

fun fuckCompanionExtend() {
    //使用伴生对象调用扩展函数
    Zebra.fuck()
    //使用容器类类名调用伴生对象的扩展函数
    Zebra.fuck()


    //使用伴生对象调用扩展函数
    Monkey.fuck()
    //用容器类类名调用伴生对象的扩展函数
    Monkey.fuck()
}
