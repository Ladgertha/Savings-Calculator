package ru.ladgertha.savingscalculator.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger

object DiProvider {

    fun buildDi(application: Application, isDebugConfig: Boolean) {
        startKoin {
            if (isDebugConfig) androidLogger() else EmptyLogger()
            androidContext(application)
            koin.loadModules(appModules)
            koin.createRootScope()
        }
    }
}
