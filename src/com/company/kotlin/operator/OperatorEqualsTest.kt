package com.company.kotlin.operator


class AssHole(val x: Int, val y: Int) {
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

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}