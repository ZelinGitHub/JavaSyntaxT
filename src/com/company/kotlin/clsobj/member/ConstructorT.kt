package com.company.kotlin.clsobj
//主构造函数是类头的一部分
//它跟在类名（与可选的类型参数）后
class Clid constructor() {

}

class Cuzz constructor(pNickname: String) {

}
//如果主构造函数，没有任何注解或者可见性修饰符，可以省略 constructor 关键字
class Keria(pNickname: String) {

}
//如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面
class public @SafeVarargs constructor(name: String) {

}
//定义带一个参数的主构造方法
//init语句块在类创建时执行和主构造方法一次调用
//主构造方法不能包含初始化代码
//可以有多个init初始化语句块
class Snake constructor(pNickname: String) {
    val nickname: String

    //初始化语句块
    init {
        //用参数为属性赋值
        nickname = pNickname
    }

}

//constructor关键字在没有注解和可见性修饰符的时候可以省略
class Snake2(pNickname: String) {
    val nickname: String

    init {
        nickname = pNickname
    }
}














