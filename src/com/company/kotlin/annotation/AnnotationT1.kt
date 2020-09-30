package com.company.kotlin.annotation

import kotlin.reflect.KClass


fun test(list: List<*>) {
    //应用注解
    @Suppress("UNCHECKED_CAST")
    val strings = list as List<String>
}

//数据类data
data class Bengi(val name: String, val age: Int)


fun test() {
    val person = Bengi("Alice", 29)
}


//声明注解JsonName
annotation class JsonName(val name: String)

//应用注解的注解元注解
@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

//声明元注解
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class BindingAnnotation

//声明注解MyBinding，应用自定义的元注解BindingAnnotation
@BindingAnnotation
annotation class MyBinding

interface Company {
    val name: String
}

//公司实现类 是数据类
data class CompanyImpl(override val name: String) : Company

data class Person(
        val name: String
        //把CompanyImpl类的字节码传入
        , @DeserializeInterface(CompanyImpl::class)
        val company: Company
)

//声明注解，参数是类的字节码
//Company::class的类型是KClass<CompanyImpl>，是KClass<out Any>的子类型
annotation class DeserializeInterface(val targetClass: KClass<out Any>)

interface ValueSerializer<T>{
    fun toJsonValue(value:T):Any?
    fun fromJsonValue(jsonValue:Any?):T
}

annotation class CustomSerializer(
        //泛型类serializerClass作为注解参数，KClass是类的字节码
        val serializerClass:KClass<out ValueSerializer<*>>
)