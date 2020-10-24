package com.company.kotlin.lambda

class ChangZhang(val name: String, val age: Int) {
    fun fuck(type: Int) {
        println("haveShit")
    }
}

fun testBindMemberReferTest() {
    val ball = ChangZhang("liSing", 4396)
    //绑定成员引用
    //使用成员引用语法，捕捉特定实例对象上的，方法引用
    //这个成员函数的引用绑定到了特定的对象上
    val getBallAge = ball::age
    val ballFuck = ball::fuck
    //不再需要传递类实例
    (ball::fuck)(0)

    (ChangZhang::age)(ball)
    (ChangZhang::fuck)(ball, 0)
}