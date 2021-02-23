package ru.ladgertha.savingscalculator.di.modules

import androidx.appcompat.app.AppCompatActivity
import org.koin.dsl.module
import ru.ladgertha.savingscalculator.utils.TermsMapper

val mapperModule = module {

    factory { (activity: AppCompatActivity) ->
        TermsMapper(
            context = activity
        )
    }
}