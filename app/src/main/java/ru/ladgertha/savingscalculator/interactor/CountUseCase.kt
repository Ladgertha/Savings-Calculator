package ru.ladgertha.savingscalculator.interactor

import java.math.BigDecimal

interface CountUseCase {
    suspend fun countSum(sum: BigDecimal, term: BigDecimal): BigDecimal

    suspend fun countTerm(sum: BigDecimal, term: BigDecimal): BigDecimal
}