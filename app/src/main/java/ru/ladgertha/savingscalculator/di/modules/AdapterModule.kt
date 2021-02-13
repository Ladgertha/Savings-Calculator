package ru.ladgertha.savingscalculator.di.modules

import androidx.appcompat.app.AppCompatActivity
import org.koin.dsl.module
import ru.ladgertha.savingscalculator.adapter.FragmentManager
import ru.ladgertha.savingscalculator.adapter.ViewPagerAdapter

val adapterModule = module {

    factory { (activity: AppCompatActivity) ->
        ViewPagerAdapter(
            activity = activity,
            fragmentManager = get() as FragmentManager
        )
    }

    factory {
        FragmentManager()
    }
}