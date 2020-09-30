package com.company.kotlin.lambda



data class MingKai(val name: String, val age: Int)

fun samsung() {
    val mingKai = listOf<MingKai>(MingKai("希特勒", 29), MingKai("海德里希", 31))
    //people.maxBy找到最大的元素 根据元素的字段age
    println(mingKai.maxBy { it.age })

    //大括号内是lambda表达式
    //参数p，参数类型MingKai，函数体p.age
    mingKai.maxBy({ p: MingKai -> p.age })

    //当lambda是唯一实参的时候，可以放到小括号外面
    mingKai.maxBy() { p: MingKai -> p.age }

    //当lambda是唯一实参的时候，可以放到小括号外面，并去掉小括号
    mingKai.maxBy { p: MingKai -> p.age }

    //推导出参数类型
    //maxBy参数类型始终和集合元素相同，所以可以推导出来
    mingKai.maxBy { p -> p.age }

    //使用默认参数名称it代替命名参数
    //当前只有一个参数的lambda，参数类型可以推导出来，就可以使用it
    //it代替了p:MingKai->p.age
    mingKai.maxBy { it.age }

    //用变量没办法推导出类型，必须显式指定参数类型
    val getAge = { p: MingKai -> p.age }

    mingKai.maxBy(getAge)

    //最后一个表达式就是lambda的结果
    val xiZaoGou = { x: Int, y: Int ->
        println("计算出$x +$y 的结果是")
        x + y
    }
    println(xiZaoGou(1, 2))

    //joinToString转换成字符串，可以接收一个lambda参数，用toString以外的方法把元素转换成字符串
    //把mingKai对象转换成人名列表
    val names = mingKai.joinToString(separator = "", transform = { p: MingKai -> p.name })
    println(names)
    //把lambda放到括号外面
    mingKai.joinToString("") { p: MingKai -> p.name }

    //把lambda存储到变量里
    //参数x y 函数体 x+y
    //lambda存储到变量里，可以把变量当做普通函数对待
    val sum = { x: Int, y: Int -> x + y }
    //直接调用lambda表达式 用双括号()
    { println(42) }()
    //调用lambda表达式
    println(sum(1, 2))
//run函数执行传递过来的lambda
    run { println(42) }



}

class Ref<T>(var value:T)
//调用默认构造函数，生成Ref对象
val counter=Ref(0)
//lambda  类counter的成员value自增
val inc={ counter.value++}


var xizaogouChuijiba=0
val huangZa={ xizaogouChuijiba++}

fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    //forEach函数的参数是一个lambda
    //如果lambda只有一个参数，参数类型可以推导出来，可以使用it代替参数
    messages.forEach {
        println("$prefix $it")
    }
    messages.forEach() {
        println("$prefix $it")
    }
    messages.forEach({
        println("$prefix $it")
    })
}

fun printProblemCounts(response: Collection<String>) {
    var clientError = 0
    var severError = 0
    //forEach函数的循环是lambda  如果lambda只有一个可以推导出的参数，可以用it替代
    //允许在lambda内部访问外部非final变量并修改
    response.forEach {
        if (it.startsWith("4")) {
            clientError++
        } else if (it.startsWith("5")) {
            severError++
        }
    }
}

