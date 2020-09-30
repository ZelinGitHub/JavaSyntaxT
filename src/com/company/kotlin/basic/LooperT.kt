package com.company.kotlin.basic

import java.util.*

//区间 两个值是区间的一部分
val oneToTen=1..10


fun fizzBuzz(i:Int)=when{
    i%15==0->"dick"
    i%3==0->"pussy"
    i%5==0->"ass"
    //转换为字符串
    else->"$i"
}

fun testk(){
    //循环遍历这个区间
    for(i in 1..100){
        print(fizzBuzz(i))
    }

    //倒序迭代
    //步长为2
    for(i in 100 downTo 1 step 2){
        print(fizzBuzz(i))
    }

    //定义treeMap
    //不需要new
    val binaryReps=TreeMap<Char,String>()
    //遍历区间
    //字符区间
    // in选择区间或集合
    for(c in 'A'..'F'){
        //得到字符二进制字符串
        val binay=Integer.toBinaryString(c.toInt())
        //为map赋值 键是字母 值是二进制字符串
        //可以map[key]取值，用赋值来更新map元素的值
        binaryReps[c]=binay
    }
    // in选择区间或集合
    //不需要单独定义变量 letter和binary默认成为键和值
    for((letter,binary)in binaryReps){
        print("$letter=$binary")
    }

    val list= arrayListOf<String>("10","11","1001")
    //不需要单独定义变量 index和element默认成为键和值
    for((index,element)in list.withIndex()){
        println("$index:$element")
    }

    print(isLetter('q'))
    print(isNotDigit('q'))
    print(recoginze('8'))
    //输出true或false 支持比较的元素都可以使用in，类实现了Comparable接口
    print("man" in "woman".."dog")

    //in也可以用于集合
    print("pig" in setOf<String>("woman","girl"))
}



//in可以判断是否在集合或区间内
fun isLetter(c:Char)=
        c in 'a'..'z'||c in 'A'..'Z'
fun isNotDigit(c:Char)=
        c !in '0'..'9'

fun recoginze(c:Char)
        =when(c){
    //in可以作为when的分支
    in '0'..'9'->"这个是数字滚你妈的"
    in 'a'..'z',in 'A'..'Z'->"这个是字母，废物"
    else ->"老板傻逼"
}
