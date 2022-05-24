package com.jonhbravo.heroes.core.utils

interface Mapper<F, out T> {
    fun map(from: F): T
}