package com.company.java.designmode.builder

/**
 * 产品类
 */
class House {

   private val mController= Controller()

    override fun toString(): String {
        return mController.toString()
    }

    /**
     * 构建类
     * 产品的构建类负责创造产品，并设置产品的属性
     */
     class Builder{
        private val mParams: Controller.Params = Controller.Params()


        fun setWall(pWall: String): Builder {
            mParams.mWall=pWall
            return this
        }

        fun setRoof(pRoof: String): Builder {
            mParams.mRoof=pRoof
            return this
        }

        fun setFoundation(pFoundation: String): Builder {
            mParams.mFoundation=pFoundation
            return this
        }

        /**
         * 创建产品并应用参数
         */
        fun create(): House {
            //创建产品
            val house = House()
            mParams.apply(house.mController)
            return house
        }
    }
}