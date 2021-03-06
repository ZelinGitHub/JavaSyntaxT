package com.company.java.designmode.decorate

import com.company.java.designmode.decorate.Pig

/**
 * 装饰类
 */
class RedPigWrapper(private val mPig: Pig): Pig {
    override fun roast() {
        mPig.roast()
    }
}