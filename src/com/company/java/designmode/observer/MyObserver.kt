package com.company.java.designmode.observer

import java.util.*

/**
 * 观察者
 * Observer是Java内置类型
 */
class MyObserver(private val mName:String) : Observer {
    /**
     * 触发函数
     * 这个函数其实是在目标内部，被观察者的引用调用的
     */
    override fun update(o: Observable?, arg: Any?) {
        println("$mName 收到通知 $arg")
    }
}