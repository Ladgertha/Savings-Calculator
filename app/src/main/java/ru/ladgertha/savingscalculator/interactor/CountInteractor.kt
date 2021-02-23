package ru.ladgertha.savingscalculator.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ladgertha.savingscalculator.repository.CountRepository
import ru.ladgertha.savingscalculator.utils.Terms
import java.math.BigDecimal

class CountInteractor(
    private val countRepository: CountRepository
) : CountUseCase {

    override suspend fun countSum(sum: BigDecimal, termCount: BigDecimal, term: Terms): BigDecimal {
        return withContext(Dispatchers.Default) {
            countRepository.countSum(sum, termCount, term)
        }
    }

    override suspend fun countTerm(
        sum: BigDecimal,
        termCount: BigDecimal,
        term: Terms
    ): BigDecimal {
        return withContext(Dispatchers.Default) {
            countRepository.countTerm(sum, termCount, term)
        }
    }
}