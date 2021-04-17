package com.company.kotlin.function

import java.lang.IllegalArgumentException

class User(val id: Int, val name: String, val address: String)

fun saveUser1(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("不能保存ID为${user.id}的用户：名字为空")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException("不能保存ID为${user.id}的用户：地址为空")
    }
}

fun saveUser2(user: User) {
    //局部函数 函数内部的函数
    //局部函数可以方位所在函数的参数和变量
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("不能保存ID为${user.id}的用户：$fieldName 为空")
        }
    }

    validate(user, user.name, "名字")
    validate(user, user.address, "地址")
}

fun saveUser3(user: User) {
    //局部函数 函数内部的函数
    //局部函数可以方位所在函数的参数和变量
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("不能保存ID为${user.id}的用户：$fieldName 为空")
        }
    }

    validate(user.name, "名字")
    validate(user.address, "地址")
}

//定义User类的扩展函数
fun User.validateBeforeSave() {
    //局部函数 函数内部的函数
    //局部函数可以方位所在函数的参数和变量
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            //扩展函数可以直接访问User类的属性id
            throw IllegalArgumentException("不能保存ID为${id}的用户：$fieldName 为空")
        }
    }


    validate(name, "名字")
    validate(address, "地址")

}

fun saveUser(user: User) {
    //调用user类的扩展函数
    user.validateBeforeSave()
}

