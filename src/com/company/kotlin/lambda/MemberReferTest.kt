package com.company.kotlin.lambda


class Bread(val name: String, val age: Int) {
    fun starveFuck(sex: Int, color: String) {
        println("Spain")
    }
}

fun testMemberReference() {
    val getAge = Bread::age
    val fuck = Bread::starveFuck
    val nextAction = ::coldFuck
    val predicate = String::isDatui
    val bread = Bread("Suck", 22)
    getAge(bread)
    fuck(bread,0,"black")
}

fun testNormalLambda() {
    val starveFuck = { bread: Bread, sex: Int, color: String -> bread.starveFuck(sex, color) }
    val bread = Bread("Suck", 22)
    starveFuck(bread, 0, "red")
}

fun invokeMemberRefer(){
    val bread = Bread("Suck", 22)
    //实例是第一个参数
    //成员引用必须使用括号包裹
    //成员引用本质上是一段lambda，即使是属性成员引用也可以执行
    (Bread::age)(bread)
    (Bread::starveFuck)(bread, 1, "black")
}

fun invokeMemberReferParamFunc() {
    val breadList = listOf<Bread>(Bread("Alice", 29), Bread("Chandler", 31))
    //maxBy函数隐式提供了一个Bread实例作为Bread::age的参数
    breadList.maxBy(Bread::age)
}


//顶层函数
fun salute() = println("Salute")

fun coldFuck(age: Int, message: String) {
    println("sb")
}

fun fuckTopFuncMemberRefer() {
    //引用顶层函数，省略类名
    run(::salute)
    //lambda保存到变量
    val action = {
        //lambda参数
        age: Int, message: String ->
        //lambda函数体，调用了顶层函数
        coldFuck(age, message)
    }
    //这个顶层函数的成员引用等价于上面的lambda
    val nextAction = ::coldFuck
}


class ChangZhang(val name: String, val age: Int) {
    fun fuck(type: Int) {
        println("haveShit")
    }
}

fun bindMemberRefer() {
    val ball = ChangZhang("liSing", 4396)
    //绑定成员引用到指定实例
    val getBallAge = ball::age
    val ballFuck = ball::fuck
    //绑定成员引用到指定实例之后，执行成员引用时，不再需要传递实例
    (ball::fuck)(0)
    //不使用绑定到实例时，执行成员引用时，需要传入实例作为参数
    (ChangZhang::age)(ball)
    (ChangZhang::fuck)(ball, 0)
}