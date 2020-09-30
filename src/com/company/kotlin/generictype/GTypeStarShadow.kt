package com.company.kotlin.generictype

import java.lang.IllegalArgumentException
import java.util.*
import kotlin.reflect.KClass

fun sktt1() {
    val list: MutableList<Any?> = mutableListOf("faker", "bengi", "bang", "marin", "wolf", "blank", "easyhoon", "huni", "peanut", "piglet", "kkoma", "duke")
    val chars = mutableListOf<Char>('α', 'β', 'γ')

    /**
     * 星号投影是包含某种特定类型的元素的列表
     * 因为不知道类型，所以不能写入，只能读取
     * 等价于<out any?>
     */
    val unknownElements: MutableList<*> =
            if (Random().nextBoolean()) list else chars

    println(unknownElements.first())

    /**
     * 定义map，保存验证器的单例对象，键是类型字节码
     */
    val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()
    validators[String::class] = DefaultStringValidator
    validators[Int::class] = DefaultIntValidator

    //map里面保存的是FieldValidator<*>，禁止写入未知类型集合
//    validators[String::class]!!.validate("")

    Validators.registerValidator(String::class,DefaultStringValidator)
    Validators.registerValidator(Int::class,DefaultIntValidator)

    println(Validators[String::class].validate("kotlin"))
    println(Validators[Int::class].validate(42))
}

/**
 * 只是读取数据可以用星号投影
 */
fun printFirst(list: List<*>) {
    if (list.isNotEmpty()) {
        println(list.first())
    }
}

/**
 * 定义类型参数T
 */
fun <T> printFirst2(list: List<T>) {
    if (list.isNotEmpty()) {
        println(list.first())
    }
}

/**
 *  验证用户输入接口
 *  T是类型参数逆变
 */
interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

/**
 * 单例对象
 * 字符串输入验证器
 */
object DefaultStringValidator : FieldValidator<String> {
    override fun validate(input: String): Boolean = input.isNotEmpty()
}

/**
 * 单例对象
 * 整数输入验证器
 */
object DefaultIntValidator : FieldValidator<Int> {
    override fun validate(input: Int): Boolean = input >= 0
}

object Validators {
    //保存验证器的map
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    //注册验证器，把验证器保存到map里面
    fun <T : Any> registerValidator(
            kClass: KClass<T>, fieldValidator: FieldValidator<T>
    ) {
        validators[kClass] = fieldValidator
    }

    /*
        不安全的逻辑都被隐藏到类的主体中
     */
    @Suppress("UNCHECKED_CAST")
    operator fun <T : Any> get(kClass: KClass<T>): FieldValidator<T> =
            validators[kClass] as? FieldValidator<T>
                    ?: throw IllegalArgumentException("没有这个${kClass.simpleName}类型的验证器")
}