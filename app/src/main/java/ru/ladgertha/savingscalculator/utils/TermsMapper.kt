package ru.ladgertha.savingscalculator.utils

import android.content.Context
import ru.ladgertha.savingscalculator.R

class TermsMapper(
    private val context: Context
) {

    fun mapStringToTerms(term: String): Terms {
        return when (term) {
            context.getString(R.string.days) -> Terms.DAYS
            context.getString(R.string.month) -> Terms.MONTHS
            context.getString(R.string.year) -> Terms.YEARS
            else -> Terms.DAYS
        }
    }
}