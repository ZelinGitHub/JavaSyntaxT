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






