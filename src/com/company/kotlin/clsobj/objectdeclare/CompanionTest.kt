package com.company.kotlin.clsobj.objectdeclare

import com.company.kotlin.basic.UziNC
import com.company.kotlin.clsobj.getFacebookName

//object对象声明
//companion定义伴生对象，可以省略类名
//伴生对象可以访问类内部的所有成员，包括private成员，包括private构造方法
//可以通过容器类名称来访问伴生对象的成员
class B {
    //有名字的伴生对象
    companion object She {
        fun bar() {
            print("companion object的bar方法被调用")
        }
    }
}

class A {
    //没有名字的伴生对象
    companion object {
        fun bar() {
            print("companion object的bar方法被调用")
        }
    }
}

//接口
interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}


//伴生对象也可以实现接口
class Person(val name: String) {
    //未命名的伴生对象，实现了接口JSONFactory
    companion object : JSONFactory<UziNC> {
        //覆盖方法，必须有关键字override
        override fun fromJSON(jsonText: String): UziNC = UziNC("蔡包子")
    }
}


class PersonX(val firstName: String, val lastName: String) {
    //空伴生对象，未命名
    //默认名字是Companion
    companion object {
    }
}

/**
 * 给伴生对象定义扩展函数
 * 省略伴生对象名字的伴生对象默认名字是Companion，定义扩展函数也用这个
 */
fun PersonX.Companion.fromJSON(json: String): PersonX {
    return PersonX("Jack", "Tom")
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

fun fuckCompanionNormal() {
    //使用伴生对象，调用伴生对象的函数
    B.She.bar()
    //通过容器类类名，调用伴生对象函数，不需要伴生对象名
    B.bar()
}

fun fuckCompanionNoName() {
    //使用默认对象名Companion，调用伴生对象函数，不需要伴生对象名
    A.Companion.bar();
    //通过容器类类名，调用伴生对象函数，不需要伴生对象名
    A.bar()
}

fun fuckCompanionInterface() {
    //Person名字可以代替伴生对象的实例
    loadFromJSON(Person)
}

//参数是伴生对象实现的接口类型
fun <T> loadFromJSON(factory: JSONFactory<T>) {

}

fun fuckCompanionExtend() {
    //用容器类类名调用伴生对象的扩展函数
    val pX = PersonX.fromJSON("{name:'Jinx'")
}

fun fuckCompanionFactory() {
    val subscribingUser = UserKK.newSubscribingUser("bob@gmail.com")
    val facebookUser = UserKK.newFacebookUser(4)
}