package com.company.kotlin.basic

import java.lang.IllegalArgumentException

//定义空接口
interface Expr
//实现接口
class Num(val  value:Int) : Expr
//类有两个属性 参数是Expr类型，自己也实现了Expr类型 和sum本身也是num
class Sum(val left: Expr, val right: Expr): Expr

fun testo(){
    //构造Sum和Num对象，不需要new
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}

fun eval(e: Expr):Int{
    //如果是Num对象
    if(e is Num){
        //as 显示转换为Num对象
//        val n=e as Num?
        //检查过类型后 不需要调用as显示类型转换
        val n=e
        //返回Num对象的value字段值
        return n.value
    }
    if(e is Sum){
        return eval(e.right) + eval(e.left)
    }

    throw IllegalArgumentException("4396")
}

//表达式函数体 if有返回值
fun eval2(e: Expr):Int=
        if(e is Num){
            e.value
        }else if(e is Sum){
            eval(e.right) + eval(e.left)
        }else{
            throw IllegalArgumentException("团战暴毙")
        }

fun eval3(e: Expr):Int=
        //when的参数可以是任意对象
        when(e){
            //允许检查when参数值的类型
            //使用is之后无需主动as转换
            is Num ->e.value
            is Sum -> eval(e.right) + eval(e.left)
            else->throw IllegalArgumentException("十秒走位零秒输出")
        }

//代码块的最后的表达式就是结果
//除了函数
//函数要么return，要是是表达式函数体
fun evalWithLogging(e: Expr):Int=
        //代码块可以作为分支体
        when(e){
            is Num ->{
                println("num:${e.value}")
                //最后一个表达式是表达式结果
                e.value
            }

            is Sum ->{
                val left= evalWithLogging(e.left)
                val right= evalWithLogging(e.right)
                //$转换为字符串值
                println("sum:$left+$right")
                //最后一个表达式作为结果返回
                left+right
            }

            else->throw IllegalArgumentException("第一赛区，零冠")

        }