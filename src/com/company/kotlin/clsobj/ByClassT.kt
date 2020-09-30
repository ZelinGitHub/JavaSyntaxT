package com.company.kotlin.clsobj

/**
 * 装饰器模式，实现arrayList同样的接口，把ArrayList定义为类的一个字段
 */
class DelegatingCollection<T> : Collection<T> {
    override val size: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun contains(element: T): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isEmpty(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iterator(): Iterator<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val innerList = arrayListOf<T>()


}

/**
 *  by声明把接口实现委托到innerList对象上，内部默认实现所有的接口方法
 */
class DelegatingCollection2<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList {

}

/**
 * 把MutableCollection的实现委托给innerSet
 * 没有覆盖的方法的实现，委托给被包装的容器innerSet
 */
class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {
    //变量var
    var objectsAdded = 0

    //覆盖默认的委托方法，提供自定义的实现
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    //覆盖默认的委托方法，提供自定义的实现
    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return (innerSet.addAll(elements))
    }
}