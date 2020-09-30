package com.company.kotlin.clsobj


interface User7 {
    //接口可以包含抽象属性声明
    val nickname: String
}

//实现nickname属性 用主构造方法
class PrivateUser(override val nickname: String) : User7

class SubscribingUser(val email: String) : User7 {
    //自定义getter 没有支持字段来存储值
    override val nickname: String
        get() = email.substringBefore('@')
}

class FaceBookUser(val accoundId: Int) : User7 {
    //有支持字段来存储值
    override val nickname = getFaceBookName(accoundId)

    private fun getFaceBookName(accoundId: Int): String = "毛狗东"
}

interface User8 {
    val email: String
    //nickname有自定义getter，但是没有支持字段，接口属性不能有支持字段
    val nickname: String
        get() = email.substringBefore('@')
}


class User9(val name: String) {
    var address: String = "火星"
        //用setter访问支持字段
        set(value: String) {
            //三引号避免转义
            //读取支持字段的值
            //使用特殊的标识符field来访问支持字段
            //使用默认访问器属性有支持字段
            //自定义访问器不使用field没有支持字段
            //自定义访问器使用field有支持字段
            print("""$name 的地址改变："$field"->"$value"。""".trimIndent())
            //更新支持字段的值
            field = value
        }
}

fun dddd() {
    val user9 = User9("张亮")
    //内部默认调用了setter方法
    user9.address = "徐家房"
}

class LengthCounter {
    //修改默认访问器的可见性
    var counter: Int = 0
        private set

    fun addWord(word:String){
        counter+=word.length
    }
}