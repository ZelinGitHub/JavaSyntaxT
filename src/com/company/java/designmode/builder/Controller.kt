package com.company.java.designmode.builder
class Controller{
   private var mWall: String = "没有"
    private var mRoof: String = "没有"
    private var mFoundation: String = "没有"
    class Params{
        var mWall: String = "没有"
        var mRoof: String = "没有"
        var mFoundation: String = "没有"

        fun  apply(controller: Controller){
            controller.mWall=mWall
            controller.mRoof=mRoof
            controller.mFoundation=mFoundation
        }
    }

    override fun toString(): String {
        return "墙：$mWall；屋顶：$mRoof；地基：$mFoundation"
    }
}
