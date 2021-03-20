package com.company.kotlin.basic

import com.company.kotlin.clsobj.Color2
import com.company.kotlin.clsobj.Color2.*
import java.lang.Exception


fun getCOlod(color2: Color2)=when(color2){
    RED,ORANGE,YELLOW->"eat shit"
    GREEN->"drink pee"
    BLUE,INDIGO,VIOLET->"good girl"
}

fun mix(c1: Color2, c2: Color2)=
        //when的参数可以是任意对象
        when(setOf<Color2>(c1,c2)){
            //setOf函数可以得到set
            setOf(RED,YELLOW)->ORANGE
            setOf(YELLOW,BLUE)->GREEN
            setOf(BLUE,VIOLET)->INDIGO
            else->throw Exception("motherFucker")
        }


fun mixOptimized(c1: Color2, c2: Color2)=
        //when 可以不带参数
        when{
            (c1==RED&&c2==YELLOW)||
                    (c1==YELLOW&&c2==RED)->
                ORANGE
            (c1==YELLOW&&c2==BLUE)||
                    (c1==BLUE&&c2==YELLOW)->
                GREEN
            (c1==VIOLET&&c2==BLUE)||
                    (c1==BLUE&&c2==VIOLET)->
                INDIGO
            else->throw Exception("go hell")

        }