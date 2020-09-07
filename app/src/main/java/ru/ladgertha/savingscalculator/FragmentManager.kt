package ru.ladgertha.savingscalculator

import androidx.fragment.app.Fragment
import ru.ladgertha.savingscalculator.ui.fragments.MainFragment
import ru.ladgertha.savingscalculator.ui.fragments.CalculateTermFragment

class FragmentManager {

    fun getFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainFragment()
            1 -> CalculateTermFragment()
            else -> MainFragment()
            // TODO ErrorFragment
        }
    }

    fun getTitle(position: Int): Int {
        return when (position) {
            0 -> R.string.main_fragment_tab_title
            1 -> R.string.calculate_fragment_tab_title
            else -> R.string.error_fragment_title
        }
    }
}