package com.company.kotlin.clsobj.companion


class Lion {
    //有名字的伴生对象
    companion object Dick {
        fun fuck() {
            print("companion object的bar方法被调用")
        }
    }
}


fun fuckCompanionNormal() {
    //使用伴生对象，调用伴生对象的函数
    Lion.Dick.fuck()
    //通过容器类类名，调用伴生对象函数，不需要伴生对象名
    Lion.fuck()
}

fun printCompanion(){
    val lionDick = Lion.Dick
    println(lionDick)
}







