package ru.ladgertha.savingscalculator

import android.app.Application
import ru.ladgertha.savingscalculator.di.DiProvider

class SavingsCalculatorApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DiProvider.buildDi()
    }
}