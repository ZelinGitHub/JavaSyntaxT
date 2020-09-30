package com.company.kotlin.collection


fun testabcde() {
    //mapOf函数创建map
// to是中缀调用
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
//中缀调用的普通形式
    val map2 = mapOf(1.to("one"), 7.to("seven"), 53.to("fifty-three"))

    //可以直接用Pair的内容来初始化两个变量 ——>解构声明
    //to创建pair 结构声明展开
    val (number, name) = 1 to "one"


    //infix允许使用中缀符号调用函数
//扩展函数
//返回Pair对象，不需要new
//Pair是系统类，表示一对元素
    infix fun Any.to(other: Any) = Pair(this, other)
}
