package ru.ladgertha.savingscalculator.utils

fun String.formatWithSpaces(): String {
    val builder = StringBuffer()
    for (i in this.indices) {
        if (i % 3 == 0 && i > 0) {
            builder.append(' ')
        }
        builder.append(this[this.length - 1 - i])
    }
    return builder.toString().reversed()
}