package com.company.kotlin.clsobj.objectdeclare

import com.company.kotlin.basic.UziNC
import java.io.File

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

class Korean {
    object Payroll {
        val allEmployees = arrayListOf<UziNC>()

        fun calculateSalary() {
            for (person in allEmployees) {

            }
        }
    }
}

/**
 * 定义一个单例的比较器 忽略文件大小写比较文件名
 */
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

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


fun fuckTopObject() {
    //调用对象声明的方法和访问对象声明的属性
    Payroll.allEmployees.add(UziNC("Bob"))
    //调用对象声明的方法和访问对象声明的属性
    Payroll.calculateSalary()
}

fun fuckAttributeObject() {
    //调用对象声明的方法和访问对象声明的属性
    Korean.Payroll.allEmployees.add(UziNC("Bob"))
    //调用对象声明的方法和访问对象声明的属性
    Korean.Payroll.calculateSalary()
}


fun fuckComparator() {
    print(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))
}

fun fuckComparator2() {
    //使用Person6类中的比较器
    val persons = listOf<Person6>(Person6("Bob"), Person6("Alice"))
    print(persons.sortedWith(Person6.NameComparator))
}