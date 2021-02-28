package com.company.java.designmode.decorate

/**
 * 装饰类
 */
class BlackPigWrapper(private val mPig: Pig) : Pig {
    override fun roast() {
        mPig.roast()
    }
}