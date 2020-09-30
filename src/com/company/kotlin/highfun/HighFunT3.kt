package com.company.kotlin.highfun


enum class Delivery {
    STANDARD, EXPEDITED
}


class Order(val itemCount: Int)

/**
 * 参数返回一个lambda
 */
fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    //加急快递模式
    if (delivery == Delivery.EXPEDITED) {
        return { order ->
            6 + 2.1 * order.itemCount
        }
    }
    //标准快递
    return { order ->
        1.2 * order.itemCount
    }
}

fun tes333t() {
    //得到lambda calculator是保存lambda的变量，函数返回lambda
    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
    //调用lambda
    println("Shipping costs ${calculator(Order(3))}")


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

data class Person2(val firstName: String, val lastName: String, val phoneNumber: String?)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    //返回lambda
    fun getPredicate(): (Person2) -> Boolean {
        //定义一个lambda
        val startsWithPrefix = { p: Person2 ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) {
            //返回lambda
            return startsWithPrefix
        }
        //返回另外一个lambda 这个lambda使用了默认参数it
        return { startsWithPrefix(it) && it.phoneNumber != null }
    }
}