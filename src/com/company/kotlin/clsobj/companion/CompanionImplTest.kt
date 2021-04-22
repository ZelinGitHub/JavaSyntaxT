package com.company.kotlin.clsobj.companion

//接口
interface HengHeng {
    fun fuck()
}

class BigPig {
    companion object Ass: HengHeng {
        override fun fuck() {
            println("BigPig companion Ass fuck")
        }
    }
}

class Piglet {
    //未命名的伴生对象
    companion object : HengHeng {
        override fun fuck() {
            println("Piglet companion fuck")
        }
    }
}




//参数是伴生对象实现的接口类型
fun cock(hengHeng: HengHeng) {
    println("cock ${hengHeng.hashCode()}")
}


fun executeCock() {
    //传递伴生对象
    cock(BigPig.Ass)
    //外围类的名字可以代替伴生对象
    cock(BigPig)
    //默认伴生对象名是Companion
    cock(Piglet.Companion)
    //外围类的名字可以代替伴生对象
    cock(Piglet)
}