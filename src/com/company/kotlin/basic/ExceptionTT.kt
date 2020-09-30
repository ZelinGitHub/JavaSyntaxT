package com.company.kotlin.basic

import java.io.BufferedReader
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

//函数参数不需要写val var
fun testabc(percenge: Int, number: Int) {
    if (percenge !in 0..100) {
        //不必使用new
        //throw是一个表达式
        throw IllegalArgumentException("世界第一洗澡狗")
    }


    val percenge =
            if (number in 0..100)
                //用number初始化percenge
                number
            else
            //是一个表达式 可以作为if表达式的一部分使用
            //抛出异常之后 percenge不会初始化
                throw IllegalArgumentException("世界第一吹J8")

    //创建BufferedReader输入流对象，不需要new
    //传入StringReader对象，构造参数是字符串
    val reader=BufferedReader(StringReader("7777"))
    print(readNumber(reader))
}

//BufferedReader输入流
//返回值可能返回int可能返回null
//没有抛出IOException，不需要throws，不区分受检异常和非受检异常
fun readNumber(reader:BufferedReader):Int?{
    //检测异常
    try {
        //取出一行
        val line=reader.readLine();
        return Integer.parseInt(line)
        //异常类型是NumberFormatException
    }catch (e:NumberFormatException){
        return null
    }
    finally {
        //关闭输入流
        reader.close()
    }

}


fun readNumber2(reader: BufferedReader){
    //try表达式的值可以赋值给变量
    //必须用大括号括起来
    //多个表达式值是最后一个的值
    val number=try {
        Integer.parseInt(reader.readLine())
        //catch表达式的值是语句内最后一个表达式的值
    }catch (e:NumberFormatException){
        return
    }
}

fun readerNumber(reader: BufferedReader){
    val number=try {
        Integer.parseInt(reader.readLine())
    }catch (e:NumberFormatException){
        null
    }
    print(number)
}