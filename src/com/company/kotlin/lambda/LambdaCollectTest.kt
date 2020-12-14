package com.company.kotlin.lambda



 class MingKai(val name: String, val age: Int)

fun testLambdaCollectTest() {
    val mingKai = listOf<MingKai>(MingKai("Hitler", 29), MingKai("John", 31))
    //people.maxBy找到最大的元素 根据元素的字段age
    println(mingKai.maxBy { it.age })

    //大括号内是lambda表达式
    //参数p，参数类型MingKai，函数体p.age
    mingKai.maxBy({ p: MingKai -> p.age })

    //当lambda是唯一实参的时候，可以放到小括号外面
    mingKai.maxBy() { p: MingKai -> p.age }

    //当lambda是唯一实参的时候，可以放到小括号外面，并去掉小括号
    mingKai.maxBy { p: MingKai -> p.age }

    //推导出参数类型
    //maxBy参数类型始终和集合元素相同，所以可以推导出来
    mingKai.maxBy { p -> p.age }

    //使用默认参数名称it代替命名参数
    //当前只有一个参数的lambda，参数类型可以推导出来，就可以使用it
    //it代替了p:MingKai->p.age
    mingKai.maxBy {
        it.age
    }


    val getAge = { p: MingKai -> p.age }

    mingKai.maxBy(getAge)




}






