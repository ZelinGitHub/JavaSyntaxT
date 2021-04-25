package com.company.kotlin.collection

/**
 * 只读集合和可变集合
 */
fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    //只读集合
    for (item in source) {
        //可变集合
        target.add(item)
    }
}

fun testMutableCollection() {
    //只读集合
    val source: Collection<Int> = arrayListOf(3, 5, 7)
    //可变集合
    val target: MutableCollection<Int> = arrayListOf(1)
    copyElements(source, target)
    println(target)


}