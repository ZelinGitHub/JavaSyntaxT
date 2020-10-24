package com.company.kotlin.lambda

import java.util.concurrent.locks.Lock

/**
 * lock是锁对象，kotlin也有可以把任何对象作为锁对象的Synchronized函数版本
 * inline函数会复制代码过去
 */
inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        //返回lambda的调用结果
        return action()
    } finally {
        lock.unlock()
    }
}

fun test() {
//    val l=Lock()
//    synchronized(l){
//
//    }
}


fun foo(l: Lock) {
    println("在同步之前")
    /**
     * 调用内联函数，将把内联函数和lambda都复制过来
     * 复制过来的lambda是这个函数代码的一部分，不是匿名内部类对象了
     */

    synchronized(l) {
        println("fuck hard")
    }
    println("在同步之后")

}


class LockOwner(val lock:Lock){
    /**
     * 传递一个保存lambda的变量，lambda代码不会被内联，只有Synchronized函数内联了
     * 当lambda被保存起来的时候，将不能内联，直接调用和传递参数可以内联
     */
    fun runUnderLock(body:()->Unit){
        synchronized(lock, body)
    }
}
//内联参数和不内联的参数
inline fun foo(inlined:()->Unit,noinline notInlined:()->Unit){

}