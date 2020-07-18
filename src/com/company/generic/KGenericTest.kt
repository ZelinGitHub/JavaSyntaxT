package com.company.generic

import java.util.*
import kotlin.collections.ArrayList


fun test() {
    var fatherApple: Apple<Father, Father> = Apple<Child, Child>()


    var list: List<*> = ArrayList<String>()
    list = ArrayList<Any>()
    list = ArrayList<Int>()


    var tomato:Tomato<*> =Tomato<Child>()
    tomato.e=null
   val child= tomato.e

    val kPair:KPair<*> = KPair<String>()
    val kPairAny:Any?=kPair.first

    val stump:Stump<*> = Stump<Father>()
    val father:Father?=stump.a
    val stumpAny:Any?=stump.a


    val stump2:Stump<Father> =Stump()
    val father2:Father?=stump2.a
    val stumpAny2:Any?=stump2.a

    val sheep:Sheep<*> =Sheep<String>()
    sheep.a=null
    val a:Any?=sheep.a
}