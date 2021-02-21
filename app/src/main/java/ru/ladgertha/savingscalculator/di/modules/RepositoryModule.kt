package ru.ladgertha.savingscalculator.di.modules

import org.koin.dsl.module
import ru.ladgertha.savingscalculator.repository.CountRepository
import ru.ladgertha.savingscalculator.repository.CountRepositoryImpl

val repositoryModule = module {

    single<CountRepository> {
        CountRepositoryImpl()
    }
}