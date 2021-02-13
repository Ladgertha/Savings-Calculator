package ru.ladgertha.savingscalculator.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import ru.ladgertha.savingscalculator.interactor.CountUseCase
import ru.ladgertha.savingscalculator.utils.Event
import java.math.BigDecimal

class MainViewModel(
    private val countInteractor: CountUseCase
) : ViewModel() {

    private val resultSumLiveData = MutableLiveData<Event<BigDecimal>>()
    private val resultTermLiveData = MutableLiveData<Event<BigDecimal>>()

    fun countSum(sum: BigDecimal, term: BigDecimal) {
        viewModelScope.launch(getCoroutineExceptionHandler()) {
            val result = countInteractor.countSum(sum, term)
            resultSumLiveData.postValue(Event(result))
        }
    }

    fun countTerm(sum: BigDecimal, term: BigDecimal) {
        viewModelScope.launch(getCoroutineExceptionHandler()) {
            val result = countInteractor.countTerm(sum, term)
            resultTermLiveData.postValue(Event(result))
        }
    }

    fun observeResultSumLiveData(): LiveData<Event<BigDecimal>> {
        return resultSumLiveData
    }

    fun observeResultTermLiveData(): LiveData<Event<BigDecimal>> {
        return resultTermLiveData
    }

    private fun getCoroutineExceptionHandler(): CoroutineExceptionHandler {
        return CoroutineExceptionHandler { _, exception ->
            // logUtils.logAndReportError(tag, exception)
        }
    }
}