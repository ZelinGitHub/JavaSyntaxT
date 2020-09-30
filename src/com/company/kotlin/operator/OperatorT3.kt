package com.company.kotlin.operator


fun yzt(){
    val p= Point(10, 20)
    /**
     * 解构声明
     * 解构声明(,)约定为多个componentN的函数
     * 数据类，编译器为每个在主构造方法中声明的属性生成一个componentN函数
     */
    val (x,y)=p

    println(x)
    println(y)
    //splitFileName返回NameComponent对象
    //(,)约定为component函数，解构声明
    val (name,ext)= splitFilename("操逼.txt")
    println(name)
    println(ext)
}

//存放文件名和扩展名
//数据类自动生成component方法
data class NameComponents(val name:String,val extension:String)

fun splitFilename(fullName:String): NameComponents {
    val result=fullName.split('.',limit = 2)

    //返回文件名和扩展名的对象
    return NameComponents(result[0], result[1])
}
fun splitFilename2(fullName:String): NameComponents {
    //split函数返回集合
    //解构声明用于集合
    val (name,ext)=fullName.split('.',limit = 2)

    //返回文件名和扩展名的对象
    return NameComponents(name, ext)
}

fun printEntries(map:Map<String,String>){
    /**
     * 在in循环中使用解构声明
     * 两个约定
     * (,)被转换为了component
     * for(x in y)被转换为了iterator
     */
    for((key,value) in map){
        println("$key -> $value")
    }
}