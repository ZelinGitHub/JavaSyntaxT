package com.company.kotlin.collection

//Array定义数组
fun main(args: Array<String>) {
    //遍历数组角标
    for (i in args.indices) {
        println("参数$i 是：${args[i]}")
    }

    //调用forEach和lambda
    args.forEachIndexed { index, element ->
        println("参数$index 是：$element")

    }
}

fun testO() {
    //参数1数组元素个数
    //参数2lambda 用来得到数组元素的值，参数是角标
    val letters = Array<String>(26) { i ->
        ('a' + i).toString()
    }
    println(letters.joinToString(""))


    val strings = listOf<String>("a", "b", "c")
    //toTypedArray集合转换为数组
    //展开运算符*
    //展开后替换%s
    println("%s/%s/%s".format(*strings.toTypedArray()))

    //创建五个Int数组，元素值为0
    //调用构造方法
    val fiveZeros = IntArray(5)
    //创建五个Int数组，元素值为0
    //调用工厂函数
    val fiveZeros2 = intArrayOf(0, 0, 0, 0, 0)

    //调用构造方法，接收一个大小和一个lambda
    val squares = IntArray(5) { i -> (i + 1) * (i + 1) }
}