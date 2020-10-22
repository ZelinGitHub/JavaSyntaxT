package com.company.kotlin.attr


interface Monkey {
    val nickname: String
        get() = "Fucker"
}
interface Reindeer {
    var nickname: String
        get() = "Fucker"
        set(value) {
            println(value)
        }
}

interface Chimpanzee {
    //接口可以包含抽象属性声明
    val nickname: String
}

//实现nickname属性 用主构造方法
class PrivateUser(override val nickname: String) : Chimpanzee

class SubscribingUser(val email: String) : Chimpanzee {
    //自定义getter 没有支持字段来存储值
    override val nickname: String
        get() = email.substringBefore('@')
}

class FaceBookUser(val accoundId: Int) : Chimpanzee {
    //有支持字段来存储值
    override val nickname = getFaceBookName(accoundId)

    private fun getFaceBookName(accoundId: Int): String = "David"
}




