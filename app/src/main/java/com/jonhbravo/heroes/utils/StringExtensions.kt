package com.jonhbravo.heroes.utils

fun String.cut(charNumber: Int, moreIndicator: String = "...") = if (this.length > charNumber) {
    substring(0..charNumber) + moreIndicator
} else {
    this
}