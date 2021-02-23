package ru.ladgertha.savingscalculator.adapter

import androidx.fragment.app.Fragment
import ru.ladgertha.savingscalculator.R
import ru.ladgertha.savingscalculator.ui.fragments.CalculatePartialSumFragment
import ru.ladgertha.savingscalculator.ui.fragments.CalculateTotalSumFragment
import ru.ladgertha.savingscalculator.utils.FragmentSteps.PARTIAL_SUM_FRAGMENT
import ru.ladgertha.savingscalculator.utils.FragmentSteps.TOTAL_SUM_FRAGMENT

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
            PARTIAL_SUM_FRAGMENT.ordinal -> R.string.calculate_partial_fragment_tab_title
            TOTAL_SUM_FRAGMENT.ordinal -> R.string.calculate_sum_fragment_tab_title
            else -> -1 // TODO ERROR TEXT
        }
    }
}