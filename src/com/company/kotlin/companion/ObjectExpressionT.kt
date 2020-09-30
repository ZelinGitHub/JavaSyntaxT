package com.company.kotlin.companion

fun htc() {
    //object定义匿名内部类 kotlin匿名累不了可以实现0或多个接口
    /* window.addMouseListener(){
         object :MouseAdapter(){
             override fun mouseClicked(e:MouseEvent){

             }
             override fun mouseEntered(e:MouseEvent){

             }
         }
     }*/
    //可以把匿名类对象分配一个名字，存储到一个变量里
/*    val listener=object:MouseAdapter{
        override fun mouseClicked(e:MouseEvent){

        }
        override fun mouseEntered(e:MouseEvent){

        }
    }*/

}

/**
 * kotlin匿名内部类可以修改创建它的函数的变量，无需置为final
 */
//fun countClicks(window: Window) {
//    val clickCount = 0
//    window.addMouseListener() {
//        object : MouseAdapter() {
//            override fun mouseClicked(e: MouseEvent) {
//                clickCount++
//            }
//
//            override fun mouseEntered(e: MouseEvent) {
//
//            }
//        }
//    }
//}