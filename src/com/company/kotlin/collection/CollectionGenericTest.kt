package com.company.kotlin.collection


//T 泛型
//支持元素为任意类型的集合
fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
): String {
    val result = StringBuilder(prefix)
    //通过index遍历 不需要定义index和element变量 自动定义直接使用
    //这个功能是解构声明，可以用Pair的内容初始化两个变量
    //实际上map元素是Pair对象
    for ((index, element) in collection.withIndex()) {
        //追加
        if (index > 0) result.append(separator)
        //追加
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

//T 泛型
//支持元素为任意类型的集合
fun <T> joinToString2(
        collection: Collection<T>,
        //参数默认值
        separator: String = ",",
        //参数默认值
        prefix: String = "",
        //参数默认值
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    //通过index遍历 不需要定义index和element变量 自动定义直接使用
    //这个功能是解构声明，可以用Pair的内容初始化两个变量
    //实际上map元素是Pair对象
    for ((index, element) in collection.withIndex()) {
        //追加
        if (index > 0) result.append(separator)
        //追加
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun executeJoinString() {
    //创建一个数组列表
    val list = arrayListOf<Int>(1, 7, 53)
    print(joinToString(list, ";", "(", ")"))
    //Kotlin可以在调用时写上参数的名字，一个写后面的都得写
    print(joinToString(list, separator = ";", prefix = "(", postfix = ")"))
    //命名参数可以任意顺序
    print(joinToString(list, prefix = "(", separator = ";", postfix = ")"))

    joinToString2(list, ",", "(", ")")
    //有默认参数值可以省略参数
    joinToString2(list, ",", ")")
    //有默认参数值可以省略参数
    joinToString2(list, ",")
    //有默认参数值可以省略参数
    joinToString2(list)
}