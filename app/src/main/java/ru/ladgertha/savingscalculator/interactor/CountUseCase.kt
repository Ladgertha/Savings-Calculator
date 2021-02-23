package ru.ladgertha.savingscalculator.interactor

import ru.ladgertha.savingscalculator.utils.Terms
import java.math.BigDecimal

interface CountUseCase {
    suspend fun countSum(sum: BigDecimal, termCount: BigDecimal, term: Terms): BigDecimal

    suspend fun countTerm(sum: BigDecimal, termCount: BigDecimal, term: Terms): BigDecimal
}