package ru.ladgertha.savingscalculator.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.ladgertha.savingscalculator.ui.fragments.MainFragment
import ru.ladgertha.savingscalculator.ui.fragments.SecondFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                MainFragment()
            }
            1 -> {
                SecondFragment()
            }
            else -> {
                // TODO Add error
                MainFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> {
                "First"
            }
            1 -> {
                "Second"
            }
            else -> {
                // TODO Add error
                "Unknown"
            }
        }
    }
}