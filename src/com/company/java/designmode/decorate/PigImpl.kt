package com.company.java.designmode.decorate

import com.company.java.designmode.decorate.Pig

/**
 * 组件实现类
 * 一个组件实现类对应一个组件抽象类，对应多个装饰类
 * 一个组件对象对应一个装饰对象，一个装饰对象内有一个组件对象的引用
 * 装饰通过组件的引用调用组件的函数
 */
class PigImpl : Pig {
    override fun roast() {}
}