package com.company.kotlin.lambda

class Ref<T>(var value:T)
//调用默认构造函数，生成Ref对象
val counter=Ref(0)
//lambda  类counter的成员value自增
val inc={ counter.value++}


var xizaogouChuijiba=0
val huangZa={ xizaogouChuijiba++}

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