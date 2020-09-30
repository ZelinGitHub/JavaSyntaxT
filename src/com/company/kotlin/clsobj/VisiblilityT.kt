package com.company.kotlin.clsobj

//internal模块内可见
internal open class TalkativeButton:Focusable{
    //自己可见
    private fun yell()= println("草泥马")
    //protected子类可见
    protected fun whisper()= println("给我口")
}

//扩展函数
//默认是public public暴露了类TalkativeButton的模块内可见
internal fun TalkativeButton.giveSpeech(){
    //扩展函数不能访问private成员yell
//    yell()
    //扩展函数不能访问protect成员yell
//    whisper()
}
fun getFacebookName(facebookAccountId: Int): String ="习猪头"
