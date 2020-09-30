package com.company.kotlin.clsobj

//定义一个接口
interface Clickable{
    //抽象方法
    fun click()
    //接口抽象方法的默认实现
    fun showOff()= println("我是可以被点击的，你算个球")
}

interface Focusable{
    fun setFocus(b:Boolean)=
            println("我${if(b) "得到" else "失去"}了焦点。")

    fun showOff()=println("我是可以得到焦点的，你算个吊")
}

//实现Clickable接口
//当实现的两个接口有相同名字的默认方法时，必须提供实现
class Button:Clickable,Focusable{
    override fun showOff() {
        //super调用父类型的接口
        //泛型表示要调用哪一个父类的
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    //实现click方法，必须使用override关键字
    override fun click() {
        println("tmd，我被点了！")
    }

}

//实现Clickable接口
//当实现的两个接口有相同名字的默认方法时，必须提供实现
class Button2:Clickable,Focusable{
    //只调用一个继承的实现
    override fun showOff() =super<Clickable>.showOff()

    //实现click方法，必须使用override关键字
    override fun click() {
        println("tmd，我被点了！")
    }

}

fun testaaa(){
    //创建Button对象
    Button().click()
    //创建对象，赋给引用button
    val button=Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}