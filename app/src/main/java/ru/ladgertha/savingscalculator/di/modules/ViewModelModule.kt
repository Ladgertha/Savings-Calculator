package ru.ladgertha.savingscalculator.di.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.ladgertha.savingscalculator.interactor.CountUseCase
import ru.ladgertha.savingscalculator.view_models.MainViewModel

val viewModelModule = module {

    viewModel {
        MainViewModel(
            countInteractor = get() as CountUseCase
        )
    }
}