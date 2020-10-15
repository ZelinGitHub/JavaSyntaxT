package com.company.kotlin.companion

import java.io.File


/**
 * 定义一个单例的比较器 忽略文件大小写比较文件名
 */
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}


fun testObjectT2() {
    print(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))
}