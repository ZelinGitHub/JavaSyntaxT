package com.company.kotlin.lambda

data class YouGiOh(val name: String, val age: Int)

fun omg() {
    val list = listOf<Int>(1, 2, 3, 4)
    //filter函数 筛选出集合中满足指定条件的元素 放到新集合中
    //it代表list元素
    println(list.filter { it % 2 == 0 })

    val youGiOhList = listOf<YouGiOh>(
            YouGiOh("凯巴", 0)
            , YouGiOh("绞脑汁", 1)
            , YouGiOh("行子", 1)
            , YouGiOh("贝卡萨斯", 0)
            , YouGiOh("挪亚", 1)
    )
    //筛选出年龄字段大于30的yougioh
    //这里的参数是一个lambda 这个lambda只有一个参数 用it代替
    println(youGiOhList.filter { it.age > 30 })

    //map对集合中每一个元素应用指定的函数，并存放到新集合中
    println(list.map { it * it })
    //替换每一个yougioh为yougioh的名字
    println(youGiOhList.map { it.name })
    //使用成员引用代替lambda
    println(youGiOhList.map { YouGiOh::name })

    //得到年龄大于30的人的名字
    youGiOhList
            .filter { it.age > 30 }
            .map { YouGiOh::name }

//筛选是要遍历每一个人的，这样做会每一个人都查找一次最大年龄，浪费效率
    youGiOhList.filter { it.age == (youGiOhList.maxBy(YouGiOh::age)?.age) }

    //得到最大年龄
    val maxAge = youGiOhList.maxBy(YouGiOh::age)?.age
    youGiOhList.filter { it.age == maxAge }

    //filterKeys筛选键 filterValues筛选值
    //mapKeys变换键 filterValues变换值
    //map就是变换 转换 映射
    val numberMap = mapOf(0 to "游给", 1 to "马克拉")
    println(numberMap.mapValues { it.value.toUpperCase() })


    //检查一个人有没有到28岁
    val canBeInClub27 = { y: YouGiOh -> y.age <= 27 }
    //判断是不是所有人都满足条件
    println(youGiOhList.all(canBeInClub27))
    //判断是否至少有一个人满足条件
    println(youGiOhList.any(canBeInClub27))
    //得到满足条件的元素的个数
    println(youGiOhList.count(canBeInClub27))
    //等价于count，但是不高效
    println(youGiOhList.filter(canBeInClub27).size)
    //得到符合条件的第一个元素，没有返回null
    println(youGiOhList.find(canBeInClub27))

    //根据通过年龄分组的map 结果是map<Int,List<YouGiOh>>
    println(youGiOhList.groupBy { it.age })

    val listS = listOf<String>("a", "ab", "b")
    //根据首字母分组，first是扩展函数，也可以做成员引用
    println(listS.groupBy(String::first))


    val books = listOf<Book>(

    )

    /*
    1把元素转换为authors，it.authors是转换后的结果（map）
    2把每个it.authors集合平铺为一个集合（flat）
     */
    books.flatMap { it.authors }.toSet()

    val strings = listOf<String>("abc", "def")
    /*
    1先把元素转换为List，it.toList是转换后的结果（map）
    2把每个元素转换后的结果平铺（flat）
     */
    println(strings.flatMap { it.toList() })


}


class Book(val title: String, val authors: List<String>)
