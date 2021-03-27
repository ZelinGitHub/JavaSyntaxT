package com.company.kotlin.lambda


class Bread(val name: String, val age: Int) {
    fun fuck(sex: Int, color: String) {
        println("Spain")
    }
}

fun fuckMemberAttr() {
    //定义一个访问成员属性的lambda
    //lambda的形参是成员属性所属的类类型
    { bread: Bread -> bread.age }
    //等价于上面的lambda表达式
    Bread::age
}

fun fuckMemberFun() {
    //定义一个调用成员函数的lambda
    //lambda的第一个形参是成员函数所属的类类型
    //lambda的其他形参是成员函数的形参
    { bread: Bread, sex: Int, color: String -> bread.fuck(sex, color) }
    //等价于上面的lambda表达式
    Bread::fuck
}

//定义顶层属性
val deadTime: Int = 0
fun fuckTopAttr() {
    //定义一个访问顶层属性的lambda
    //lambda没有形参
    { ->
        //访问顶层属性
        deadTime
    }
    //等价于上面的lambda
    ::deadTime
}

//定义顶层函数
fun fuckToDead(age: Int, message: String) {
    println("sb")
}

fun fuckTopFun() {
    //定义一个调用顶层函数的lambda
    //lambda的形参是顶层函数的形参
    { age: Int, message: String ->
        //调用顶层函数
        fuckToDead(age, message)
    }
    //等价于上面的lambda
    ::fuckToDead
}


//定义扩展属性
val String.nc: Int
    get() {
        return 111
    }

fun fuckExtendAttr(){
    //定义一个访问扩展属性的lambda
    //lambda的第一个形参是扩展属性的接收者类型
    { str: String ->
        //访问扩展属性
        str.nc
    }
    //等价于上面的lambda
    String::nc
}


//定义扩展函数
fun String.isNt() = length >= 21
fun fuckExtendFun() {
    //定义一个调用扩展函数的lambda
    //lambda的第一个形参是扩展函数的接收者类型
    { str: String ->
        //调用扩展函数
        str.isDatui()
    }
    //等价于上面的lambda
    String::isNt
}


fun invokeMemberRefer() {
    val bread = Bread("Suck", 22)
    val breadAge = (Bread::age)(bread)
    (Bread::fuck)(bread, 1, "black")
    val deadTime = ::deadTime
    (::fuckToDead)
}



fun bindMemberRefer() {
    val ball: Bread = Bread("liSing", 4396)
    val str:String="abc"
    //绑定成员引用到指定实例
    //绑定成员引用到指定实例之后，执行成员引用时，不再需要传递实例
    val ballAge = ball::age
    (ball::fuck)(0,"red")
    val nc=str::nc
    (str::isNt)()
}