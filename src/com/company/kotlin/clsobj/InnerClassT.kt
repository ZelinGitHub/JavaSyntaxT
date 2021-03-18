package com.company.kotlin.clsobj

class Outer{
    //inner生命内部类
    inner class Inner{
        //得到外部类的引用
        //this@Outer外部类的引用
        fun getOuterReference():Outer=this@Outer
    }
}
