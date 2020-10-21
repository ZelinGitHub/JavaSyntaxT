package com.company.kotlin.func
//导入扩展函数
//使用as修改导入的类或函数的名字
import com.company.kotlin.func.lastChar as last

val ddd="4396瞎子之王".last()

/**
 * 扩展函数 为集合Collection添加扩展函数
 * 扩展函数不能被子类重写
 * 成员函数优先级大于扩展函数
 */
fun<T> Collection<T>.joinToString(
        separator:String=",",
        prefix:String="",
        postfix:String=""
):String{
    val result = StringBuilder(prefix)
    //通过index遍历 不需要定义index和element变量 自动定义直接使用
    //this可以省略
    for ((index, element) in this.withIndex()) {
        //追加
        if (index > 0) result.append(separator)
        //追加
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun testzzz(){
    val list= listOf<Int>(1,2,3)
    //调用集合的扩展函数
    print(list.joinToString(separator = ";",prefix = "(",postfix = ")"))
    //默认参数值
    print(list.joinToString())
}

//只能用于String集合的扩展函数
fun Collection<String>.join(
        separator: String=",",
        prefix: String="",
        postfix: String=""
//省略了this  调用集合的其他扩展函数作为这个函数的函数体
)=this.joinToString(separator,prefix,postfix)
