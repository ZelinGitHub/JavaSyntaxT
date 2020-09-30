package com.company.kotlin.lambda


fun aabbcc() {
    val mingKaiList = listOf<MingKai>(MingKai("希特勒", 29), MingKai("海德里希", 31))

    //把成员函数保存到变量
    //age实际上是get函数
    //getAge是成员引用

    val getAge = MingKai::age
    //成员引用等价于下面的lambda表达式
    val getAge2 = { mingKai: MingKai -> mingKai.age }
    //需要一个类实例来调用这个成员引用，这里省略了类实例
    mingKaiList.maxBy(MingKai::age)


    //引用顶层函数，省略类名
    run(::salute)
    //lambda保存到变量
    val action = {
        //lambda参数
        mingKai: MingKai, message: String ->
        //lambda函数体，调用了顶层函数
        fuck(mingKai, message)
    }

    //这个顶层函数的成员引用等价于上面的lambda
    val nextAction = ::fuck

    //保存构造方法，延期执行创建类实例的工作
    val createUziSb = ::UziSb
    val p = createUziSb("uzi", 777)
    println(p)

    //定义扩展函数isDatui
    fun MingKai.isDatui() = age >= 21
    //扩展函数的成员引用
    val predicate = MingKai::isDatui

    val mangseng = MingKai("lising", 4396)
    //保存成员函数到变量
    val personsAgeFunction = MingKai::age
    //需要一个类实例mangseng来调用这个成员函数的引用
    println(personsAgeFunction(mangseng))

    //绑定成员引用
    //使用成员引用语法，捕捉特定实例对象上的，方法引用
    //mangseng是一个对象
    //这个成员函数的引用绑定到了特定的对象上
    val dmitrysAgeFunction=mangseng::age
    //不再需要类实例来调用成员函数的引用
    println(dmitrysAgeFunction())
}


data class UziSb(val name: String, val age: Int)
//顶层函数
fun salute() = println("Salute")

fun fuck(mingKai: MingKai, message: String) {

}
