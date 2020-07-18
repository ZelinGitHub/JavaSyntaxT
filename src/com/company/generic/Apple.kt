package com.company.generic

class Apple<out T, out E> {
    val sugar: T? = null
    val size: E? = null
    private var color: T? = null
    fun eat(): T? {
        return null
    }
}
