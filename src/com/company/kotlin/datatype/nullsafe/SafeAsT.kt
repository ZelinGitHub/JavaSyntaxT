package com.company.kotlin.datatype.nullsafe

class UziSb(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        //安全转换as，如果不是合适的类型返回null
        val otherPerson = other as?UziSb ?: return false
        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int {
       return firstName.hashCode() * 37 + lastName.hashCode()
    }
}