package com.company.kotlin.lambda


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