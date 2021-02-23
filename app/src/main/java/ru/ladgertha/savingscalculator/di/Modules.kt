package ru.ladgertha.savingscalculator.di

import ru.ladgertha.savingscalculator.di.modules.*

val appModules = listOf(
    adapterModule,
    interactorModule,
    mapperModule,
    repositoryModule,
    viewModelModule
)