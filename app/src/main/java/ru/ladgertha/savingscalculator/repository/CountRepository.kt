package ru.ladgertha.savingscalculator.repository

import ru.ladgertha.savingscalculator.utils.Terms
import java.math.BigDecimal

interface CountRepository {

    fun countSum(sum: BigDecimal, termCount: BigDecimal, term: Terms): BigDecimal

    fun countTerm(sum: BigDecimal, termCount: BigDecimal, term: Terms): BigDecimal
}