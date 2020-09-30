package com.company.kotlin.clsobj



//定义带一个参数的主构造方法
//init语句块在类创建时执行和主构造方法一次调用
//主构造方法不能包含初始化代码
//可以有多个init初始化语句块
class User2 constructor(pNickname: String){
    val nickname:String

    //初始化语句块
    init {
        //用参数为属性赋值
        nickname=pNickname
    }
}


//constructor关键字在没有注解和可见性修饰符的时候可以省略
class User3(pNickname: String){
    //初始化代码可以不发放到init语句块内，因为初始化代码可以放到属性的声明里
    val nickname=pNickname;
}



//括号内是主构造方法
//属性用构造函数参数初始化的时候，可以把属性定义和参数定义合二为一
class User4(val nickname:String)

//构造方法参数默认值
class User(val nickname: String,val isSubscribed:Boolean=true)


fun dhd(){
    //不需要new 直接调用构造方法
    val alice=User("阿拉屎")
    val bob=User("抱波",false)
    val carol=User("快撸",isSubscribed = false)
}

open class User5(val nickname: String){

}

//继承User5 调用父类构造函数
class TwitterUser(nickname: String):User5(nickname){

}
//生成默认空构造方法
open class ButtonG
//即使父类是默认空构造方法，也要显式调用
class RadioButton:ButtonG()

//私有化构造方法 类外部的代码无法实例这个对象
class Secretive private constructor(){

}


