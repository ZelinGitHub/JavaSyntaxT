package com.company.kotlin.lambda


class Bread(val name: String, val age: Int) {
    fun fuck(sex: Int,color:String) {
        println("Spain")
    }
}


fun testMemberReference() {


    //引用属性
    val getAge = Bread::age
    //等价于下面的lambda表达式
    val getAge2 = { bread: Bread -> bread.age }


    //引用函数
    val fuck = Bread::fuck
    val fuck2 = { bread: Bread, sex: Int,color:String -> bread.fuck(sex,color) }


    val bread = Bread("Suck", 22)
    (Bread::age)(bread)

    (Bread::fuck)(bread,1,"black")

    getAge(bread)
    fuck(bread,0,"red")


    //需要一个类实例来调用这个成员引用，这里省略了类实例
    val breadList = listOf<Bread>(Bread("Alice", 29), Bread("Chandler", 31))
    breadList.maxBy(Bread::age)
}