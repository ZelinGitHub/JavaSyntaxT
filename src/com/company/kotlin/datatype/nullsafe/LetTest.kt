package com.company.kotlin.datatype.nullsafe

/**
 * 非空类型
 */
fun sendEmailTo(email: String) {
    println("发送邮件到 $email")
}

fun jin() {
    //可空类型
    val email: String? = "abc"
    if (email != null)
        sendEmailTo(email)

    //安全调用let函数
    /**
     * let函数把调用let的对象，变成lambda的参数
     * let函数是安全调用的，所以在lambda内部可以放心使用email
     */
    email?.let {
        //lambda参数
        email ->
        //使用lambda参数
        sendEmailTo(email)
    }


    email?.let {
        //当前只有一个参数的lambda，参数类型可以推导出来，就可以使用it
        sendEmailTo(it)
    }


    var pig: String? = "xjp@qq.com"
    pig?.let { sendEmailTo(it) }
    pig = null

    pig?.let { sendEmailTo(it) }

    val person: Person? = getTheBestPersonInTheWorld()
    if (person != null) sendEmailTo(person.name)

    //省略变量person  it代表person，推导而来
    getTheBestPersonInTheWorld()?.let { sendEmailTo(it.name) }

}


fun getTheBestPersonInTheWorld(): Person? = null
