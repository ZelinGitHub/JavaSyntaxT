package com.company.kotlin.lambda


data class UziSb(val name: String, val age: Int)


fun testMemberReferTest3(){

    //保存构造方法，延期执行创建类实例的工作
    val createUziSb = ::UziSb
    val p = createUziSb("uzi", 777)
    println(p)

}