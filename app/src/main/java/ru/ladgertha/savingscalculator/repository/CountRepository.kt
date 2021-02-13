package ru.ladgertha.savingscalculator.repository

import java.math.BigDecimal

interface CountRepository {

    fun countSum(sum: BigDecimal, term: BigDecimal): BigDecimal

    fun countTerm(sum: BigDecimal, term: BigDecimal): BigDecimal
}