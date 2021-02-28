package com.company.java.designmode.observer

import java.util.*

/**
 * 目标
 * 目标类和观察者类是一对一的
 * 目标对象和观察者对象是一对多的，目标持有观察者引用的列表
 * 订阅：就是把观察者的引用添加到目标内的列表中
 * 发布通知：遍历观察者引用列表，依次用观察者的引用，调用观察者的函数
 * Observable是Java内置类型
 */
class MyObservable : Observable() {
    fun notifyDataChanged(str: String) {
        //标识状态或内容发生改变
        setChanged()
        //通知所有观察者
        notifyObservers(str)
    }
}