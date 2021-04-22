package com.company.kotlin.clsobj.companion

class Tiger {
    //没有名字的伴生对象
    companion object {
        fun eat() {
            print("Tiger companion eat")
        }
    }
}

fun fuckCompanionNoName() {
    //使用默认对象名Companion，调用伴生对象函数，不需要伴生对象名
    Tiger.Companion.eat();
    //通过容器类类名，调用伴生对象函数，不需要伴生对象名
    Tiger.eat()
}