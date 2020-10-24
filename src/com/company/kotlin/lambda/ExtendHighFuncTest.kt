package com.company.kotlin.lambda

import java.lang.StringBuilder


/**
 * 扩展函数
 */
fun String.filter(predicate:(Char)->Boolean):String{
    val sb= StringBuilder()
    for(index in 0 until  length){
        val element=get(index)
        //如果是想要的元素，predicate是lambda
        if(predicate(element)){
            sb.append(element)
        }
    }
    return  sb.toString()
}

fun<T> Collection<T>.joinToString2(
        separator:String=",",
        prefix:String="",
        postfix:String="",
        //lambda参数，函数类型的参数，这个参数有默认值，有默认的lambda
        transform:(T)->String={it.toString()}
):String{
    val result = StringBuilder(prefix)
    //通过index遍历 不需要定义index和element变量 自动定义直接使用
    //this可以省略
    for ((index, element) in this.withIndex()) {
        //追加
        if (index > 0) result.append(separator)
        //追加
        //调用lambda
        result.append(transform(element))
    }
    result.append(postfix)
    return result.toString()
}
fun<T> Collection<T>.joinToString(
        separator:String=",",
        prefix:String="",
        postfix:String="",
        //lambda参数，函数类型的参数，这个参数可以为空
        transform:((T)->String)?=null
):String{
    val result = StringBuilder(prefix)
    //通过index遍历 不需要定义index和element变量 自动定义直接使用
    //this可以省略
    for ((index, element) in this.withIndex()) {
        //追加
        if (index > 0) result.append(separator)
        //追加
        //调用lambda
        //安全调用
        val str=transform?.invoke(element)
        //使用空合并运算符 不为空结果是transform?.invoke(element)
        //为空结果是element.toString()
                ?:element.toString()
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}


fun testHighFuncT2(){
    val letters= listOf<String>("fuck","asshole","pussy")
    //使用默认的lambda参数值
    println(letters.joinToString ())
    //传入lambda
    println(letters.joinToString { it.toLowerCase() })
    //传递命名参数
    println(letters.joinToString (separator = "! ",postfix = "! ",transform = {it.toUpperCase()}))
}




