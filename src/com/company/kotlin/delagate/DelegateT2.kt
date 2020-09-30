package com.company.kotlin.delagate

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * 工具类
 */
open class PropertyChangeAware {
    /**
     *  PropertyChangeSupport维护了属性监听器列表
     */
    protected val changeSupport = PropertyChangeSupport(this)

    /**
     * PropertyChangeListener 属性监听器
     */
    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        //增加属性监听器
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        //移除属性监听器
        changeSupport.removePropertyChangeListener(listener)
    }
}

class PersonZ(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            //通过field访问属性背后的支持字段
            val oldValue = field
            //给属性别后的支持字段赋新值
            field = newValue
            //通过监听器列表通知改变到监听器
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }
    var salary: Int = salary
        set(newValue) {
            //通过field访问属性背后的支持字段
            val oldValue = field
            //给属性别后的支持字段赋新值
            field = newValue
            //通过监听器列表通知改变到监听器
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }


}

fun testORG() {
    val p = Person("华盛顿", 34, 20000)
    /**
     * 增加监听器
     * 把监听器增加到监听器列表changeSupport
     * sam构造方法，参数是lambda，触发监听器时要做的事
     */
    p.addPropertyChangeListener(PropertyChangeListener { event ->
        println("属性 ${event.propertyName}")
    })

    //调用set方法  将触发监听器
    p.age=35
    //调用set方法  将触发监听器
    p.salary=-10000000
}

/**
 * 属性辅助类
 * 属性名，属性值，监听器列表
 */
class ObservablePropertyZ(val propName: String, var propValue: Int, val changeSupport: PropertyChangeSupport) {
    fun getValue(): Int = propValue
    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        //通过监听器列表通知改变到监听器
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}


class PersonY(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    //年龄属性辅助类
    val ageObservableProperty = ObservablePropertyZ("age", age, changeSupport)
    //get和set方法
    var age: Int
        get() = ageObservableProperty.getValue()
        set(value) {
            ageObservableProperty.setValue(value)
        }

    //薪水属性辅助类
    val salaryObservableProperty = ObservablePropertyZ("salary", salary, changeSupport)
    //get和set方法
    var salary: Int
        get() = salaryObservableProperty.getValue()
        set(value) {
            salaryObservableProperty.setValue(value)
        }
}

/**
 * 属性辅助类
 * 属性值，属性监听集合
 */
class ObservablePropertyY(var propValue: Int,val changeSupport: PropertyChangeSupport){
    //重载getValue
    operator fun  getValue(p: PersonX, prop:KProperty<*>):Int=propValue
    //重载setValue
    operator fun setValue(p: PersonX, prop:KProperty<*>, newValue: Int){
        val oldValue=propValue
        propValue=newValue
        changeSupport.firePropertyChange(prop.name,oldValue,newValue)
    }
}


/**
 * 使用委托属性
 * 把年龄和薪水作为委托属性委托给委托ObservableProperty
 * get和set方法将调用委托ObservableProperty的getValue和setValue
 */
class PersonX(val name:String,age:Int,salary:Int): PropertyChangeAware(){
    var age:Int by ObservablePropertyY(age, changeSupport)
    var salary:Int by ObservablePropertyY(salary, changeSupport)
}

/**
 * 使用kotlin标准类库的委托
 * 这个委托是属性辅助类
 * 这个辅助类没有触发监听的代码，所以需要手动传递lambda
 */
class Person(val name:String,age:Int,salary:Int): PropertyChangeAware(){
    /**
     * 定义一个lambda
     * 参数是属性、属性旧值，属性新值
     * 触发监听集合中的监听
     */
    private val observer={
        prop:KProperty<*>,oldValue:Int,newValue:Int->
        changeSupport.firePropertyChange(prop.name,oldValue,newValue)
    }
    //系统委托Delegates的函数调用
    var age:Int by Delegates.observable(age,observer)
    //系统委托Delegates的函数调用
    var salary:Int by Delegates.observable(salary,observer)
}