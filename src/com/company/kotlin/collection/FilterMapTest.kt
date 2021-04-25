package com.company.kotlin.collection


fun filterForEven() {
    val intList = listOf<Int>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val intList2 = intList.filter { it->it % 2 == 0 }

    println("过滤前 $intList")
    println("过滤后 $intList2")
}

data class Bear(val name: String = "", val age: Int = 0)


fun filterAgeAbove30() {

    val bear1 = Bear("Hitler", 20)
    val bear2 = Bear("Stalin", 40)
    val bear3 = Bear("Johan", 60)

    val people = listOf<Bear>(
            bear1, bear2, bear3
    )

    val people2 = people.filter { it->it.age > 30 }

    println("过滤前 $people")
    println("过滤后 $people2")
}

fun mapMultiply() {
    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8)
    val list2 = list.map {
        it->it * it
    }
    println("变换前 $list")
    println("变换后 $list2")
}

fun mapName() {
    val bear1 = Bear("Hitler", 20)
    val bear2 = Bear("Stalin", 40)
    val bear3 = Bear("Johan", 60)
    val people = listOf<Bear>(
            bear1, bear2, bear3
    )
    val peopleNames = people.map {it-> it.name }
    println("变换前 $people")
    println("变换后 $peopleNames")
}

fun filterAndMap() {
    val bear1 = Bear("Hitler", 20)
    val bear2 = Bear("Stalin", 40)
    val bear3 = Bear("Johan", 60)
    val people = listOf<Bear>(
            bear1, bear2, bear3
    )
    val peopleNames = people.filter { it->it.age > 30 }.map { it->it.name }
    //使用成员引用代替lambda
    //成员引用不能使用大括号包裹
    val peopleNames2 = people.filter { it->it.age > 30 }.map(Bear::name)
    println("过滤变换前 $people")
    println("过滤变换后 $peopleNames")
}

fun maxByAndFilter() {
    val bear1 = Bear("Hitler", 20)
    val bear2 = Bear("Stalin", 40)
    val bear3 = Bear("Johan", 60)
    val bear4 = Bear("Tom", 60)
    val people = listOf<Bear>(
            bear1, bear2, bear3, bear4
    )
    val maxAgePeople = people.maxBy { it->it.age }
    //使用成员引用代替lambda
    //成员引用不能使用大括号包裹
    val maxAgePeople2 = people.maxBy(Bear::age)
    val maxAge = maxAgePeople?.age
    val people2 = people.filter {
        it.age == maxAge
    }
    println("操作前 $people")
    println("操作后 $people2")
}

fun mapMap() {
    val numbers = mapOf<Int, String>(0 to "zero", 1 to "one")
    //只变换所有value，不影响key
    val numbers2 = numbers.mapValues {
        it.value.toUpperCase()
    }
    println("变换前 $numbers")
    println("变换后 $numbers2")
}