package com.company.kotlin.dsl


/**
 * 所有元素的父类，包括table、tr行，td列
 */
open class Tag(val name: String) {
    //保存所有嵌套标签
    private val children = mutableListOf<Tag>()

    //初始化子标签，参数1是子标签，参数2是初始化子标签的lambda，是一个扩展函数
    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }

    //输出html字符串
    override fun toString() = "<$name>${children.joinToString(" ")}</$name>}"
}

/**
 * 初始化table，参数是一个lambda
 */
fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

/**
 * 表格类
 */
class TABLE : Tag("table") {
    //初始化每一个行的方法，参数是lambda，调用父类的doInit方法
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}

/**
 * 行类
 */
class TR : Tag("tr") {
    //初始化每一个单元格的方法，参数是lambda，调用父类的doInit方法
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}

/**
 * 单元格类
 */
class TD : Tag("td")

/**
 * 调用各个方法创建一个表格
 */
fun createTable() =
//创建表格
        table {
            //创建行
            tr {
                //创建单元格
                td {

                }
            }
        }

/**
 * 创建一个两行的表格
 */
fun createAnotherTable()=
        //创建表
        table {
    //in定义区间
    for (i in 1..2){
        //创建行
        tr{
            //创建单元格
            td {

            }
        }
    }
}
fun bang() {
    println(createTable())
    println(createAnotherTable())
}