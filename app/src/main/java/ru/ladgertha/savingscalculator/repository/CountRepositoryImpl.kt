package ru.ladgertha.savingscalculator.repository

import java.math.BigDecimal

class CountRepositoryImpl : CountRepository {

    override fun countSum(sum: BigDecimal, term: BigDecimal): BigDecimal {
        return sum / term
    }

    override fun countTerm(sum: BigDecimal, term: BigDecimal): BigDecimal {
        return sum * term
    }
}