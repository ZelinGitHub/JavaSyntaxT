package com.company.kotlin.clsobj.specialclass

class Client(val name:String,val postalCode:Int){
    //在hashSet集合中，判断元素是否相等首先要判断hashCode
    override fun hashCode(): Int=name.hashCode()*31+postalCode
    //kotlin对象==比较内部默认调用了equals
    override fun equals(other: Any?): Boolean {
        if(other==null||other!is Client){
            return false
        }
        return name==other.name&&
                postalCode==other.postalCode
    }
    //覆盖toString
    override fun toString(): String ="客户(名字=$name，邮政编码=$postalCode)"

    //复制类的方法
    fun copy(name: String=this.name,
             postalCode: Int=this.postalCode)=
            //表达式函数体可以省略函数返回类型
            Client(name,postalCode)
}

/**
 *  data声明默认内部生成hashCode、equals、toString方法
 *  没有在主构造方法里面声明的属性不会加到默认方法里面
 */
data class Client1(val name:String,val postalCode: Int)

fun fuck(){
    //创建对象
    val bob= Client("习近平",213)
    //复制对象，创建副本，改变邮编
    print(bob.copy(postalCode = 78))
}

