package com.company.kotlin.clsobj


class King constructor(pNickname: String) {
    //初始化代码可以不发放到init语句块内，因为初始化代码可以放到属性的声明里
    val nickname = pNickname;
}
//括号内是主构造方法
//属性用构造函数参数初始化的时候，可以把属性定义和参数定义合二为一
class King1 constructor(val nickname: String)

//构造方法参数默认值
class King2 constructor(val nickname: String, val isSubscribed: Boolean = true)

fun testConstuctorT2() {
    val alice = King("阿拉屎")
    val bob = King2("抱波", false)
    val carol = King2("快撸", isSubscribed = false)
}