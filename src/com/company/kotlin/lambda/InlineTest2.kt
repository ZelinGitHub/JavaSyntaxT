package com.company.kotlin.lambda


class Egg(val name:String,val age:Int){

}

fun lpl() {
    val people = listOf<Egg>(Egg("Carol", 26), Egg("Kite", 22))

    //filter是内联函数
    println(people.filter { it.age < 30 })
    //lambda表达式和成员引用
    println(people.filter { it.age > 30 }.map(Egg::age))
}