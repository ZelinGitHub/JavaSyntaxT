package com.company.kotlin.operator

/**
 * operator被用在了基类的接口中，无需再重复
 */
class Mata(val firstName:String,val lastName:String):Comparable<Mata>{
    /**
     * <,>,<=,>=约定为compareTo函数
     */
    override fun compareTo(other: Mata): Int {
        //Person::lastName是成员引用
        return compareValuesBy(this,other, Mata::lastName, Mata::firstName)
    }
}