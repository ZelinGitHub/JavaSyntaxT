package com.company.kotlin.dsl

/**
 * 接待员
 * 参数问候
 * 重载invoke方法，可以直接调用类对象，把类的对象当做方法调用
 * 重载了()括号运算符
 * ()约定为invoke
 */
class Greeter(val greeting: String) {
    operator fun invoke(name: String) {
        println("$greeting,$name")
    }
}


fun bengi() {
    val chineseGreeter = Greeter("你好废物")
    //调用类的对象，当做函数，实际上调用的invoke方法，重载了()括号运算符
    chineseGreeter("习近平")

    val i1 = Issue("1", "ssg", "漏洞", "主要的", "击败skt失败")
    val i2 = Issue("2", "ssw", "特色", "正常的", "解散")
    //创建predicate对象
    val predicate = ImportantIssuesPredicate("ssg")
    //predicate被当做lambda传入
    for (issue in listOf(i1, i2).filter(predicate)) {
        println(issue.id)
    }

    val dependencies = DependencyHandler()
    //调用compile方法
    dependencies.compile("a.b.c.v4.lib")
    //把类对象当函数调用，参数带接收者的lambda
    dependencies {
        compile("a.b.c.v13.lib")
    }
}


data class Issue(val id: String, val project: String, val type: String, val priority: String, val description: String)

/**
 * 函数类型（lambda）作为基类
 * lambda本质是一个Function接口，有一个抽象invoke方法
 * 继承lambda必须重载invoke方法
 */
class ImportantIssuesPredicate(val project: String) : (Issue) -> Boolean {
    //覆盖父类的invoke方法
    override fun invoke(issue: Issue): Boolean {
        return issue.project == project && issue.isImportant()
    }

    //扩展函数
    private fun Issue.isImportant(): Boolean {
        return type == "漏洞" &&
                (priority == "主要的" || priority == "关键的")
    }

}


class DependencyHandler {
    fun compile(coordinate: String) {
        println("增加依赖在$coordinate")
    }

    //重载invoke，参数是扩展函数的lambda
    operator fun invoke(body: DependencyHandler.() -> Unit) {
        body()
    }
}