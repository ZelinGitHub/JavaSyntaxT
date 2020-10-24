package com.company.kotlin.lambda

class Desk(val name:String)

fun lookForPig(people: List<Desk>) {
    //传递一个l匿名函数
    //匿名函数就是lambda，写成了函数形式
    //参数是person，类型被推断出来
    people.forEach(fun(person) {
        if (person.name == "习包子") {
            println("枪毙")
            //return可以返回匿名函数
            return
        }
        println("这个叫${person.name} 的人，不是傻逼")

    })
}

fun abcde() {
    //filter函数可以使用匿名函数参数，匿名函数可以替代lambda，可以有返回值
    people.filter(fun(person): Boolean {
        return person.age < 30
    })
    //表达式函数体
    people.filter(fun(person) = person.age < 30)

}