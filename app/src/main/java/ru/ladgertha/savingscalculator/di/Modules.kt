package ru.ladgertha.savingscalculator.di

import ru.ladgertha.savingscalculator.di.modules.adapterModule
import ru.ladgertha.savingscalculator.di.modules.interactorModule
import ru.ladgertha.savingscalculator.di.modules.repositoryModule
import ru.ladgertha.savingscalculator.di.modules.viewModelModule

val appModules = listOf(
    adapterModule,
    interactorModule,
    repositoryModule,
    viewModelModule
)