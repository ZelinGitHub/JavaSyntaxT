package com.company.kotlin.datatype.nullsafe


class MyService{
    fun performAction():String="煞笔"
}


class MyTest1{
    //可空值
    private var myService: MyService?=null

//     * 初始化MyService
    fun setUp(){
        myService= MyService()
    }


}
class MyTest{
    //延迟初始化
    // 延迟初始化的属性必须是var
    //属性在初始化之前访问蒋得到异常
    private lateinit var myService: MyService

//     * 初始化MyService
    fun setUp(){
        myService= MyService()
    }

}