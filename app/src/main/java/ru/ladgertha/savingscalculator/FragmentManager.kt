package ru.ladgertha.savingscalculator

import androidx.fragment.app.Fragment
import ru.ladgertha.savingscalculator.FragmentSteps.PARTIAL_SUM_FRAGMENT
import ru.ladgertha.savingscalculator.FragmentSteps.TOTAL_SUM_FRAGMENT
import ru.ladgertha.savingscalculator.ui.fragments.CalculatePartialSumFragment
import ru.ladgertha.savingscalculator.ui.fragments.CalculateTotalSumFragment

class FragmentManager {

    fun getFragment(position: Int): Fragment {
        return when (position) {
            PARTIAL_SUM_FRAGMENT.ordinal -> CalculatePartialSumFragment()
            TOTAL_SUM_FRAGMENT.ordinal -> CalculateTotalSumFragment()
            else -> CalculatePartialSumFragment() // TODO ERROR FRAGMENT
        }
    }

    fun getTitle(position: Int): Int {
        return when (position) {
            PARTIAL_SUM_FRAGMENT.ordinal -> R.string.main_fragment_tab_title
            TOTAL_SUM_FRAGMENT.ordinal -> R.string.calculate_fragment_tab_title
            else -> -1 // TODO ERROR TEXT
        }
    }
}