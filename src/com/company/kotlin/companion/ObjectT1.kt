package com.company.kotlin.companion

import com.company.kotlin.basic.UziNC
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.File
import java.io.Serializable

class Korean {
    object Payroll {
        val allEmployees = arrayListOf<UziNC>()

        fun calculateSalary() {
            for (person in allEmployees) {

            }
        }
    }
}


fun testObjectT1() {
    //调用对象声明的方法和访问对象声明的属性
    Korean.Payroll.allEmployees.add(UziNC("Bob"))
    //调用对象声明的方法和访问对象声明的属性
    Korean.Payroll.calculateSalary()

}



