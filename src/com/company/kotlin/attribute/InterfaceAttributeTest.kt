package com.company.kotlin.attribute


interface Monkey {
    val nickname: String
        get() = "Fucker"
}

interface Reindeer {
    var nickname: String
        get() = "Fucker"
        set(value) {
            println(value)
        }
}

class BlackMonkey : Monkey {
    override val nickname: String
        get() = super.nickname
}

class BlueMonkey : Monkey {
    override val nickname: String = "Tom"
}

class RedReindeer : Reindeer {
    override var nickname: String
        get() = super.nickname
        set(value) {
        }
}

class GreenReindeer : Reindeer {
    override var nickname: String = "Jack"
}




