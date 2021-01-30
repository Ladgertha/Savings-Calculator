package ru.ladgertha.savingscalculator.adapter

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.ladgertha.savingscalculator.FragmentManager
import ru.ladgertha.savingscalculator.FragmentSteps
import ru.ladgertha.savingscalculator.ui.fragments.CalculatePartialSumFragment
import ru.ladgertha.savingscalculator.ui.fragments.CalculateTotalSumFragment

class ViewPagerAdapter(fragmentManager: FragmentActivity) :
    FragmentStateAdapter(fragmentManager) {

    override fun createFragment(position: Int): Fragment {
        return FragmentManager().getFragment(position)
    }

    override fun getItemCount(): Int {
        return FragmentSteps.values().size
    }
}