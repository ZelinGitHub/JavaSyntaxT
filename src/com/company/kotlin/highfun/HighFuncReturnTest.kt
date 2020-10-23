package com.company.kotlin.highfun


/**
 * 返回函数类型
 */
fun getShippingCostCalculator(delivery: String): (itemCount: Int) -> Double {
    //加急快递模式
    if (delivery == "EXPEDITED") {
        return { itemCount ->
            6 + 2.1 * itemCount
        }
    }
    //标准快递
    return { itemCount ->
        1.2 * itemCount
    }
}

data class Person2(val firstName: String, val lastName: String, val phoneNumber: String?)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    //返回lambda
    fun getPredicate(): (Person2) -> Boolean {
        //定义一个函数类型变量
        val startsWithPrefix = { p: Person2 ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }
        //返回一个lambda
        return { startsWithPrefix(it) && it.phoneNumber != null }
    }
}

fun testHighFuncReturnTest() {
    val calculator = getShippingCostCalculator("EXPEDITED")
    //执行lambda
    println("Shipping costs ${calculator(3)}")


    val constacts = listOf<Person2>(Person2("路飞", "蒙奇", "110"), Person2("索隆", "赏金猎人", "110"))
    val contactListFilters = ContactListFilters()
    //接收者contactListFilters
    with(contactListFilters) {
        //省略接收者
        prefix = "口"
        //省略接收者
        onlyWithPhoneNumber = true
    }
    //使用getPredicate返回的lambda传递参数
    println(constacts.filter(contactListFilters.getPredicate()))
}
