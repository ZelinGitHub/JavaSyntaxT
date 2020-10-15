package com.company.kotlin.companion


/**
 * 在类中的对象声明同样是全局单例的
 */
 class Person6(val name: String) {
    object NameComparator : Comparator<Person6> {
        override fun compare(o1: Person6, o2: Person6): Int =
                o1.name.compareTo(o2.name)
    }

    object NameComparator2 : Comparator<Person6> {
        override fun compare(o1: Person6, o2: Person6): Int =
                o1.name.compareTo(o2.name)
    }
}

fun testObjectT3(){
    //使用Person6类中的比较器
    val persons = listOf<Person6>(Person6("Bob"), Person6("Alice"))
    print(persons.sortedWith(Person6.NameComparator))
}