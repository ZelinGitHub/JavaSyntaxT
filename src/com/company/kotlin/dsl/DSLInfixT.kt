package com.company.kotlin.dsl

import java.lang.AssertionError


/**
 * 中缀函数和扩展函数should
 * 参数类型是Matcher接口
 */
infix fun <T> T.should(matcher: Matcher<T>) = matcher.test(this)

/**
 * 声明接口Matcher，声明泛型T
 */
interface Matcher<T> {
    fun test(value: T)
}

/**
 * 定义Matcher接口的子类
 */
class StartWith(val prefix: String) : Matcher<String> {
    override fun test(value: String) {
        //如果不是这个前缀
        if (!value.startsWith(prefix)) {
            throw AssertionError("废物！字符串值 $value 不是以$prefix 开头的！")
        }
    }
}


fun bitch() {
    //中缀调用
    "kotlin" should StartWith("kot")
    //普通调用
    "sktt1blank".should(StartWith("sktt1"))
    //中缀函数should传入参数Start返回start的wrapper对象调用with函数
    "kotlin" should Start with "kot"
    //中缀函数should传入参数End返回end的wrapper对象调用with函数
    "kotlin" should End with "lin"
}

//单例对象Start
object Start

object End


/**
 * 中缀函数和扩展函数should
 * 返回包装类StartWrapper
 * 参数是单例对象start
 * start单例对象的意义是当做参数，来区分不同的should函数的
 */
infix fun String.should(x: Start): StartWrapper = StartWrapper(this)

infix fun String.should(x: End): EndWrapper = EndWrapper(this)

/**
 * Start包装类
 */
class StartWrapper(val value: String) {
    infix fun with(prefix: String) {
        //如果不是这个前缀
        if (!value.startsWith(prefix)) {
            throw AssertionError("废物！字符串值 $value 不是以$prefix 开头的！")
        }
    }
}
/**
 * end包装类
 */
class EndWrapper(val value: String) {
    infix fun with(endFix: String) {
        //如果不是这个前缀
        if (!value.endsWith(endFix)) {
            throw AssertionError("废物！字符串值 $value 不是以$endFix 结尾的！")
        }
    }
}