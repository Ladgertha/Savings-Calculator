package ru.ladgertha.savingscalculator.di.modules

import org.koin.dsl.module
import ru.ladgertha.savingscalculator.interactor.CountInteractor
import ru.ladgertha.savingscalculator.interactor.CountUseCase
import ru.ladgertha.savingscalculator.repository.CountRepository

val interactorModule = module {

    factory<CountUseCase> {
        CountInteractor(
            countRepository = get() as CountRepository
        )
    }
}