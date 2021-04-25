package com.company.kotlin.collection

fun processCollections() {
    val strList = listOf<String>("first", "second", "fourteenth")
    val intSet = setOf<Int>(1, 14, 2)

    //列表最后一个
    print(strList.last())
    //set中最大的
    print(intSet.max())


}

