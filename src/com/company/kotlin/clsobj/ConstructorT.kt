package com.company.kotlin.clsobj



//定义带一个参数的主构造方法
//init语句块在类创建时执行和主构造方法一次调用
//主构造方法不能包含初始化代码
//可以有多个init初始化语句块
class Snake constructor(pNickname: String){
    val nickname:String

    //初始化语句块
    init {
        //用参数为属性赋值
        nickname=pNickname
    }

}

//constructor关键字在没有注解和可见性修饰符的时候可以省略
class Snake2(pNickname: String){
    val nickname:String
    init {
        nickname=pNickname
    }
}














