package com.company.kotlin.delagate


class Email {

}

fun loadEmails(person2: Person2): List<Email> {
    return listOf()
}
//
//class Person2(val name: String) {
//    private var _emails: List<Email>? = null
//    val emails: List<Email>
//        get() {
//            if (_emails == null) {
//                //不空无需加载
//                //懒加载
//                _emails = loadEmails(this)
//            }
//            return _emails!!
//        }
//}

/**
 *     //懒加载
使用lazy返回的委托
lazy函数的参数是一个lambda
 */
class Person2(val name: String) {
    val email by lazy { loadEmails(this) }
}

