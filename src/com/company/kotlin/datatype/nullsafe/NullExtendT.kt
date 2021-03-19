package com.company.kotlin.datatype.nullsafe

/**
 * 可空型
 * 扩展函数可以接收null并在函数内处理
 */
fun verifyUserInput(input:String?){
    //可空型的扩展函数
    if(input.isNullOrBlank()){
        println("草拟妹给我口")
    }
}


