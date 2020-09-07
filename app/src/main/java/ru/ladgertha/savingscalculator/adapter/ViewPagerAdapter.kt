package ru.ladgertha.savingscalculator.adapter

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.ladgertha.savingscalculator.ui.fragments.MainFragment
import ru.ladgertha.savingscalculator.ui.fragments.CalculateTermFragment

private const val FRAGMENTS_COUNT = 2

class ViewPagerAdapter(fragmentManager: FragmentActivity) :
    FragmentStateAdapter(fragmentManager) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                MainFragment()
            }
            1 -> {
                CalculateTermFragment()
            }
            else -> {
                // TODO Add error
                MainFragment()
            }
        }
    }

    override fun getItemCount(): Int {
        return FRAGMENTS_COUNT
    }
}