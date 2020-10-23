package com.company.kotlin.lambda

class ChangZhang(val name: String, val age: Int){
    fun fuck(){
        println("first")
    }
}

fun testBindMemberReferTest() {
    val mangseng = ChangZhang("liSing", 4396)
    //保存成员函数到变量
    val personsAgeFunction = ChangZhang::age
    //需要一个类实例mangseng来调用这个成员函数的引用
    println(personsAgeFunction(mangseng))

    //绑定成员引用
    //使用成员引用语法，捕捉特定实例对象上的，方法引用
    //这个成员函数的引用绑定到了特定的对象上
    val getMangSengAge = mangseng::age
    val mangSengFuck=mangseng.fuck()
    //不再需要传递类实例
    println(getMangSengAge())
}