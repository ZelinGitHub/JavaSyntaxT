package com.company.kotlin.array

fun createArrayLambda(){
    //参数1：数组大小
    //参数2：lambda
    val arr :Array<Int> = Array(3,{it -> it.inc()})//
}

fun generateEmptyArray(){
    var array:Array<Int> = emptyArray<Int>()
    //可以创建空数组，然后依次添加元素
    for(i in 0..2){
        array+=i
    }
}
fun generateValuesArray(){
    //创建指定元素数组
    val arr:Array<Int> = arrayOf(1, 2, 3)
}

//基本类型数组
fun generateBaseTypeArray(){
    val intArr: IntArray = intArrayOf(1,2,3)
    val longArr: LongArray = longArrayOf(1L,2L,3L)
    val floatArr: FloatArray = floatArrayOf(1.0f,2.0f,3.0f)
    val doubleArr: DoubleArray = doubleArrayOf(1.0,2.02,3.03333)
    val booleanArr: BooleanArray = booleanArrayOf(false,true,false)
}

//创建元素都为null的数组
fun generateNullArray(){
    val fixedSizeArray:Array<Int?> = arrayOfNulls<Int>(6)
}