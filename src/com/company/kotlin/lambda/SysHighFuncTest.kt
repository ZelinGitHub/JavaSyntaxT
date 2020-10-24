package com.company.kotlin.lambda

data class SiteVisit(
        val path: String,
        val duration: Double,
        val os: OS
)

enum class OS {
    WINDOWS, LINUX, MAC, IOS, ANDROID
}

/**
 * 平台类型抽取为一个参数 os
 * 扩展函数
 */
fun List<SiteVisit>.averageDurationFor(os: OS) =
        filter { it.os == os }.map(SiteVisit::duration).average()

/**
 * 参数是lambda
 */
fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
//参数是保存了lambda的变量
        filter(predicate)
                .map(SiteVisit::duration).average()


fun testSysHighFunc() {
    val log = listOf<SiteVisit>(
            SiteVisit("/", 34.0, OS.WINDOWS)
            , SiteVisit("/", 34.0, OS.LINUX)
            , SiteVisit("/", 34.0, OS.MAC)
            , SiteVisit("/", 34.0, OS.IOS)
            , SiteVisit("/", 34.0, OS.ANDROID)

    )

    val averageWindowDuration = log
            //参数是一个lambda
            .filter { it.os == OS.WINDOWS }
            //参数成员引用，成员引用本质是一个返回对象成员的lambda
            .map(SiteVisit::duration)
            .average()

    println(averageWindowDuration)

    //调用扩展函数
    println(log.averageDurationFor(OS.WINDOWS))
    println(log.averageDurationFor(OS.MAC))


    //只对移动平台的数据感兴趣
    val averageMobileDuration = log
            //参数是一个lambda
            .filter { it.os in setOf<OS>(OS.IOS, OS.ANDROID) }
            //参数成员引用，成员引用本质是一个返回对象成员的lambda
            .map(SiteVisit::duration)
            .average()

//用lambda作为参数
    println(log.averageDurationFor { it.os in setOf<OS>(OS.ANDROID, OS.IOS) })
    println(log.averageDurationFor { it.os == OS.IOS && it.path == "/signup" })
}
