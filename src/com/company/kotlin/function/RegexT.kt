package com.company.kotlin.function

fun abc() {
    //用正则表达式来拆分字符串
    print("12.345-6.A".split("\\.|-".toRegex()))
    //用字符串拆分字符串
    print("12.345-6.A".split("", "-"))

    parsePath("/User/yole/kotlin-book/chapter.adoc")
}

/*
只用String的扩展函数解析文件路径
 */
fun parsePath(path: String) {
    //取出最后一个/之前的
    val directory = path.substringBefore("/")
    //取出最后一个/之后的
    val fullName = path.substringAfterLast("/")
    //取出最后一个.之前的
    val fileName = fullName.substringBeforeLast("")
    //取出最后一个.之后的
    val extension = fullName.substringAfterLast("")

    println("Dir:$directory,name:$fileName,ext:$extension")
}


fun parsePath2(path: String) {
    //三重引号括起来的是正则表达式，三重引号不需要对任何字符进行转义+-
    //.表示任意字符
    //+表示任意多个
    //(.+)表示最后一个斜线之前的
    // /表示最后一个斜线
    //(.+)表示最后一个点之前的
    // \.表示最后一个点 正则表达式用\.表示点
    //(.+)表示扩展名
    val regex="""(.+)/(.+)\.(.+)""".toRegex()
    val matchResult=regex.matchEntire(path)

    if(matchResult!=null){
        //初始化三个变量
        val(directory,filename,extension)=matchResult.destructured;
        println("Dir:$directory,name:$filename,ext:$extension")

    }

    //三重引号可以包含任意字符 包括换行符
    //可以包含换行，而不用\n，不需要转义字符\
    val kotlinLogo="""
        .|  //
        .|//
        .|/  \
    """
    //trimMargin删除每行的前缀和前面的空格
    //trimMargin是扩展函数
    println(kotlinLogo.trimMargin(""))

    //$取出$符号的字面值
    //嵌入式表达式{'$'}
    val price="""${'$'}99.9"""
    println(price)
}