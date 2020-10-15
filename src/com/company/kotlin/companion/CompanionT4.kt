package com.company.kotlin.companion

import com.company.kotlin.clsobj.getFacebookName

/**
 * 拥有多个构造方法的类
 */
class UserK {
    val nickname: String

    //定义从构造方法
    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    //定义从构造方法
    constructor(facebookAccountId: Int) {
        nickname = getFacebookName(facebookAccountId)
    }


}

/**
 * 私有化主构造方法
 * 用工厂方法来创造UserKK对象
 * 工厂方法模式
 */
class UserKK private constructor(val nickname: String) {
    //定义伴生对象，胜率类名
    companion object {
        //工厂方法，得到容器类对象
        //可以判断是否为空，创造单例
        fun newSubscribingUser(email: String) =
                UserKK(email.substringBefore('@'))

        //工厂方法，得到容器类对象
        //可以判断是否为空，创造单例
        fun newFacebookUser(accountId: Int) =
                UserKK(getFacebookName(accountId))
    }

}


fun <T> loadFromJSON(factory: JSONFactory<T>) {

}

fun testCompanionT4() {
    val subscribingUser = UserKK.newSubscribingUser("bob@gmail.com")
    val facebookUser = UserKK.newFacebookUser(4)
}