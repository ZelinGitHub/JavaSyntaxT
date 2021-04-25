package com.company.kotlin.collection

fun createCollections() {
    val strList = listOf<String>("first", "second", "fourteenth")
    val intArrayList = arrayListOf<Int>(1, 7, 53)

    val intSet = setOf<Int>(1, 14, 2)
    val intHashSet = hashSetOf<Int>(1, 7, 53)

    val intStrMap = mapOf<Int, String>(1 to "one", 7 to "seven", 53 to "fifty-three")
    //to是一个普通函数，这里是中缀调用
    val intStrHashMap = hashMapOf<Int, String>(1 to "one", 7 to "seven", 53 to "fifty-three")
}
