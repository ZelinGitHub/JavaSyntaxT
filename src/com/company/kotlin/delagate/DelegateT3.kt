package com.company.kotlin.delagate

/**
 * 动态定义的属性集的对象
 * 自订对象
 */
class MingKai {
    //属性是一个map
    private val _attributes = hashMapOf<String, String>()

    //设置map中指定键的值
    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    //获取map中指定键的值
    val name: String
        get() = _attributes["name"]!!
}

fun _4396() {
    val m = MingKai()
    val data = mapOf<String, String>("名字" to "明凯", "公司" to "龙坑")
    for ((attrName, value) in data) {
        m.setAttribute(attrName, value)
    }
    //隐藏了attributes.getValue的调用
    println(m.name)


}

/**
 *     //把map作为委托属性，放到by后面
系统在map和MutableMap上定义了getValue和setValue扩展函数
属性名name和值自动作为map的名和值
 */
class UsbZi {
    private val _attributes = hashMapOf<String, String>()
    //设置map中指定键的值
    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    //把map作为委托属性，放到by后面
    val name: String by _attributes
}