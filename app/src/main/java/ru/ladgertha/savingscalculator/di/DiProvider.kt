package ru.ladgertha.savingscalculator.di

import org.koin.core.context.startKoin

object DiProvider {

    fun buildDi() {
        startKoin {
            modules(appModules)
        }
    }
}
