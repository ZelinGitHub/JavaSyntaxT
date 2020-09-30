package com.company.kotlin.generictype


/**
 * 定义泛型T
 *  目标和源的泛型一样
 */
fun <T> copyData(source: MutableList<T>, destination: MutableList<T>) {
    //遍历源
    for (item in source) {
        //拷贝到目标
        destination.add(item)
    }
}

/**
 * 定义泛型TR
 * T的泛型上界R
 */
fun <T : R, R> copyData2(source: MutableList<T>, destination: MutableList<R>) {
    //遍历源
    for (item in source) {
        //拷贝到目标
        destination.add(item)
    }
}

/**
 * 定义泛型T
 * 使用点变形，泛型协变out T，source的类型参数可以是T和T的子类型
 * source是一个MutableList的投影，使用受限
 */
fun <T> copyData3(source: MutableList<out T>, destination: MutableList<T>) {
    //遍历源
    for (item in source) {
        //拷贝到目标
        destination.add(item)
    }
}

/**
 * 定义泛型T
 * 使用点变形，泛型逆变in T，destination的类型参数可以是T和T的父类型
 * source是一个MutableList的投影，使用受限
 */
fun <T> copyData4(source: MutableList<T>, destination: MutableList<in T>) {
    //遍历源
    for (item in source) {
        //拷贝到目标
        destination.add(item)
    }
}