package com.company.kotlin.generictype

fun htc() {
    /**
     * 泛型实参是Any，Comparator的泛型是逆变的
     */
    val anyComparator = Comparator<Any> { e1, e2 ->
        e1.hashCode() - e2.hashCode()
    }

    val strings: List<String> = listOf("习近平", "张德江", "王岐山")
    //Comparator<Any>可以赋给Comparator<String>，因为Comparator的泛型是逆变的
    strings.sortedWith(anyComparator)
}

/**
 * 在类型参数P逆变，在类型参数R协变
 */
interface Function<in P,out R>{
    operator fun invoke(p:P):R
}

