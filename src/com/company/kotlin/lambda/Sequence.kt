package com.company.kotlin.lambda

import java.io.File

fun s8() {
    val mingKaiList = listOf<MingKai>(
            MingKai("希特勒", 29)
            , MingKai("海德里希", 31)
            , MingKai("希姆莱", 31)
            , MingKai("戈林", 20)
            , MingKai("Abc", 20)
    )
    mingKaiList
            //map结束会创建中间集合
            .map(MingKai::name)
            .filter { it.startsWith("A") }

    //列表转换成序列
    mingKaiList.asSequence()
            //序列支持和集合相同的api
            .map(MingKai::name)
            .filter { it.startsWith("A") }
            //序列转换为列表
            .toList()


    listOf<Int>(1, 2, 3, 4)
            .asSequence()
            //中间操作
            //最后一个表达式是lambda的结果，也是变换的结果
            .map { println("map($it)");it * it }
            //筛选出变换结果中%2等于0的
            .filter { println("filter($it)");it % 2 == 0 }
            //末端操作 末端操作执行前才会执行中间操作
            .toList()


    println(
            listOf<Int>(1, 2, 3, 4)
                    .asSequence()
                    //序列是一个元素一个元素操作的，可能在遍历完所有元素前找着了it>3的元素，剩下的元素就不会执行map和find
                    .map {
                        it * it
                    }
                    .find { it > 3 }
    )

    println(mingKaiList.asSequence()
            .map(MingKai::name)
            //变换为name，it变成了name
            .filter { it.length<4 }
            .toList())
    println(mingKaiList.asSequence()
            //后执行变换，it还是mingkai
            //先过滤可以减少变换的次数
            .filter { it.name.length<4 }
            .map(MingKai::name)
            .toList())


    //生成自然数列表的序列 从0开始 0 1 2 3 4 5 6 7 8 9....
    val naturalNumbersSequence= generateSequence(0){
        it+1
    }
    //得到序列指定条件（前100）的元素
    val numbersTo100Sequence=naturalNumbersSequence.takeWhile { it<=100 }
    //求100以内所有自然数之和
    // 直到末端操作sum，序列中的数字才会求值
    //求序列元素之和
    println(numbersTo100Sequence.sum())

    //定义扩展函数
    fun File.isInsideHiddenDirectory()=
    //生成序列，这个是父文件列表的序列，第一个元素是this自己
            generateSequence (this){ it.parentFile }
                    //判断序列中的元素，是否存在隐藏的，对整个序列调用
                    .any { it.isHidden }

    val file=File("/Users/a/b/c/d/e.avi")
    println(file.isInsideHiddenDirectory())
}