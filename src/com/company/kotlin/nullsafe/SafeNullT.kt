package com.company.kotlin.nullsafe

import java.lang.IllegalArgumentException

/**
 * 只定义String 是非空类型
 */
fun strLen(s:String)=s.length

/**
 * 加上？是可空类型
 */
fun strLenSafe(s:String?):Int=
        //和null比较过 就会记住 在作用域内当做非空处理
        if(s!=null) s.length else 0



fun mingKai(){
    val ceo=Employee("习近平",null)

    val developer=Employee("王岐山",ceo)

    //输出管理人的名字
    println(manageName(developer))
    println(manageName(ceo))
}

fun printAllCaps(s :String?){
    /**
     * 安全调用符?.
     * 为null不调用，表达式返回null
     */
    val allCaps:String?=s?.toUpperCase()
    println(allCaps)
}

/**
 * 字段2manager可空
 */
class Employee(val name:String,val manager: Employee?)

/**
 * 返回值可空
 * manager?.name安全调用，manager为空返回null
 */
fun manageName(employee: Employee):String?=employee.manager?.name


class Address(val streetAddress:String,val zipCode:Int,val city:String,val country:String)

//地址可为空
class Company(val name: String,val address:Address?)

//公司可为空
class Person(val name: String,val company: Company?)

fun Person.countryName():String{
    //安全调用address 安全调用country
    val country=this.company?.address?.country
    return if(country!=null) country else "不知道滚粗"
}

/**
 * 可空类型
 */
fun foo(s:String?){
    //?: 空合并运算符，如果值为空，返回代替null的默认值
    val t:String=s?:""
}

/**
 * String?可空类型
 * s?.安全调用
 * ?:空合并运算符
 */
fun strLenSafe3(s:String?):Int=s?.length?:0

fun Person.contryName()=company?.address?.country?:"不知道滚粗"


fun printShippingLabel(person:Person){
    val address=person.company?.address?:throw  IllegalArgumentException("没这个地址 垃圾")
    //with函数，参数1是接收者，参数2是lambda
    //with结构用来代替重复的address
    with(address){
        //address.streetAddress
        println(streetAddress)
        println("$zipCode $city,$country")
    }
}