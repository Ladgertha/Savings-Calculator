package ru.ladgertha.savingscalculator.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ladgertha.savingscalculator.repository.CountRepository
import java.math.BigDecimal

class CountInteractor(
    private val countRepository: CountRepository
) : CountUseCase {

    override suspend fun countSum(sum: BigDecimal, term: BigDecimal): BigDecimal {
        return withContext(Dispatchers.Default) {
            countRepository.countSum(sum, term)
        }
    }

    override suspend fun countTerm(sum: BigDecimal, term: BigDecimal): BigDecimal {
        return withContext(Dispatchers.Default) {
            countRepository.countTerm(sum, term)
        }
    }
}