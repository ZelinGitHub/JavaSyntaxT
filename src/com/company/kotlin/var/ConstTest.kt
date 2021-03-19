package com.company.kotlin.`var`

const val COUNTRY_USA = "The United States of America"
const val COUNTRY_UK = "The United Kingdom of Great Britain and Northern Ireland"
const val COUNTRY_ROC="The Republic of China"

class States{
    fun union(){
        val union:String= COUNTRY_ROC+ COUNTRY_UK+ COUNTRY_USA
    }
}