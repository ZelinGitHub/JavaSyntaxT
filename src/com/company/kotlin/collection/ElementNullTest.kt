package com.company.kotlin.collection

import java.io.BufferedReader
import java.lang.NumberFormatException

/**
 * list元素可空List<Int?>
 * list可空List<Int>?
 */
fun readNumbers(reader:BufferedReader):List<Int?>{
    //元素可空
    val result=ArrayList<Int?>()
    //一行内容
    for(line in reader.lineSequence()){
        try{
            //当前行解析成整数
            val  number=line.toInt()
            result.add(number)
        }
        catch (e:NumberFormatException){
            //不能解析成整数的行添加null
            result.add(null)
        }
    }
    return result
}


fun addValidNumbers(numbers:List<Int?>){
    var  sumOfValidNumbers=0
    var invalidNumbers=0
    for(number in numbers){
        if(number!=null){
            sumOfValidNumbers+=number
        }else{
            invalidNumbers++
        }
    }

    println("有效数字的和是：$sumOfValidNumbers")
    println("无效数字的个数是：$invalidNumbers")
}


fun addValidNumbers2(numbers: List<Int?>){
    val validNumbers=numbers.filterNotNull()
    println("有效数字的和是：${validNumbers.sum()}")
    println("无效数字的个数是：${numbers.size-validNumbers.size}")
}


