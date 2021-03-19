package com.company.kotlin.attribute

val String.lastChar: Char
    get() {
        return get(length - 1)
    }

var StringBuilder.lastChar: Char
    get() {
        return get(length - 1)
    }
    set(value: Char) {
        setCharAt(length - 1, value)
    }
