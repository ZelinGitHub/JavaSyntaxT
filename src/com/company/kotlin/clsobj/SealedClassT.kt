package com.company.kotlin.clsobj

//sealed表示这个类的所有直接子类必须嵌套在父类中
//sealed默认带open
sealed class Expr{
    class Num(val value:Int):Expr()
    class Sum(val left:Expr,val right:Expr):Expr()
}

fun eval(e:Expr):Int=
        when(e){
            is Expr.Num->e.value
            is Expr.Sum->eval(e.right)+ eval(e.left)
        }
