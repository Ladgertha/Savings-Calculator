package ru.ladgertha.savingscalculator.repository

import ru.ladgertha.savingscalculator.utils.Terms
import java.math.BigDecimal

class CountRepositoryImpl : CountRepository {
    private val monthDays = BigDecimal.valueOf(30)
    private val yearDays = BigDecimal.valueOf(365)

    override fun countSum(sum: BigDecimal, termCount: BigDecimal, term: Terms): BigDecimal {
        return when (term) {
            Terms.DAYS -> sum / termCount
            Terms.MONTHS -> {
                sum / (termCount * monthDays)
            }
            Terms.YEARS -> {
                sum / (termCount * yearDays)
            }
        }
    }

    override fun countTerm(sum: BigDecimal, termCount: BigDecimal, term: Terms): BigDecimal {
        return when (term) {
            Terms.DAYS -> sum * termCount
            Terms.MONTHS -> {
                sum * termCount * monthDays
            }
            Terms.YEARS -> {
                sum * termCount * yearDays
            }
        }
    }
}