package com.company.kotlin.operator

import java.math.BigDecimal

data class Point(val x: Int, val y: Int) {
    /**
     *  plus约定为+
     *  重载+运算符
     */
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    /**
     * ==和!= 约定为equals函数
     * 参数可以为空，先判断是否为null，再判断相等
     */
    //equals的实现由编译器在Any中实现，所以只需重载，在Any类中已经被operator声明
    override fun equals(other: Any?): Boolean {
        //恒等运算符检查两个对象的地址，不能被重载
        if (other === this) return true
        if (other !is Point) return false
        return other.x == x && other.y == y
    }


}


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


/**
 *  运算符重载也可以是扩展函数
 */
operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

/**
 * 重载*运算符
 */
operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}


/**
 * 重载*运算符
 */
operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

fun testQT() {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)

    val p = Point(10, 20)
    //运算符重载不要求两个运算数是相同的类型
    println(p * 1.5)
    //and是位运算符与
    println(0x0F and 0xF0)
    //or是位运算符或
    println(0x0F or 0xF0)
    //带符号左移四位
    println(0x0F shl 4)


    var point = Point(1, 2)
    //复合赋值符运算符
    point += Point(3, 4)
    println(point)

    val numbers = ArrayList<Int>()
    //修改对象但是不分配引用
    numbers += 42
    println(numbers[0])


    val list = arrayListOf<Int>(1, 2)
    list += 3

    val newList = list + listOf<Int>(4, 5)

    val pxd= Point(10, 20)
    println(-pxd)

    var bd=BigDecimal.ZERO
    //调用重载过后的自加运算符
    println(bd++)
    println(++bd)
    
    val person1= Mata("曼施坦因", "德国")
    val person2= Mata("蒙哥马利", "英国")
    println(person1<person2)

    //<内部调用compareTo
    println("abc"<"bac")
}

/**
 * 重载+=运算符  +=约定为plusAssign
 */
operator fun<T> MutableCollection<T>.plusAssign(element:T){
    this.add(element)
}
/**
 * 重载一元运算符
 */
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

/**
 * 重载自加运算符 ++约定为函数inc
 */
operator fun BigDecimal.inc()=this+BigDecimal.ONE