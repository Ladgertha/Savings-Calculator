package ru.ladgertha.savingscalculator

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics
import ru.ladgertha.savingscalculator.di.DiProvider

class SavingsCalculatorApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        DiProvider.buildDi(this, BuildConfig.DEBUG)
    }
}