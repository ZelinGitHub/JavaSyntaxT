package com.company.kotlin.generictype

fun testADC() {
    //kotlin可以自动推导泛型
    val authros = listOf("bang", "deft", "pray", "ruler", "iboy")
    //kotin如果不能自动推导类型，则必须写明泛型
    val readers4: MutableList<String> = mutableListOf()
    //等价上面
    val readers2 = mutableListOf<String>()


    val letters = ('a'..'z').toList()
    /*
    调用泛型函数的时候指定泛型
    泛型类和泛型接口是在继承和实现的时候指定泛型
     */
    //指定类型实参
    println(letters.slice<Char>(0..2))
    //系统推导类型实参
    println(letters.slice(0..2))


    val authors = listOf<String>("faker", "bdd", "rookie", "perkz", "caps", "ucal", "pawn", "crown")
    val readers = mutableListOf<String>("khan", "letme", "smeb", "untara", "huni")
    //自动推导出it的类型 filter是高阶函数
    readers.filter { it !in authors }

    //输出扩展属性
    println(listOf(1, 2, 3, 4).penultimate)


}

/*
扩展属性
定义泛型的扩展属性，普通属性不能有泛型
扩展属性必须定义get方法，扩展属性不能初始化
 */
val <T> List<T>.penultimate: T
    get() = this[size - 2]

/**
 * 扩展函数
 * 定义泛型函数
 * 定义类型形参T
 * 接收者和返回类型的类型都是T
 * 参数是一个区间
 */
fun <T> List<T>.slice(indices: IntRange): List<T> {
    return listOf()
}
