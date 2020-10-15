package com.company.kotlin.companion

import com.company.kotlin.basic.UziNC
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.File
import java.io.Serializable

/**
 * 对象声明
 * object定义一个类并同时创建对象
 * 只有一个对象，这个对象是单例的
 * 对象声明使用构造方法没有意义
 */
object Payroll {
    val allEmployees = arrayListOf<UziNC>()

    fun calculateSalary() {
        for (person in allEmployees) {

        }
    }
}

fun testObjectT() {
    //调用对象声明的方法和访问对象声明的属性
    Payroll.allEmployees.add(UziNC("Bob"))
    //调用对象声明的方法和访问对象声明的属性
    Payroll.calculateSalary()

}



