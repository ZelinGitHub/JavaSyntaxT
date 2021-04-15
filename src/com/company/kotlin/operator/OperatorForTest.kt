package com.company.kotlin.operator

import java.time.LocalDate


/**
 * for(x in list){}结构约定为iterator
 */
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
//object定义匿名对象
        //使用Sam构造方法，大括号里面是一个lambda
        object : Iterator<LocalDate> {
            var current = start
            override fun hasNext(): Boolean =
                    current <= endInclusive

            /**
             * apply函数，接收者是current，参数是lambda
             */
            override fun next()=current.apply{
                //当前日期增加一天
                current=plusDays(1)
            }

        }