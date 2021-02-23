package ru.ladgertha.savingscalculator.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.ladgertha.savingscalculator.utils.FragmentSteps

class ViewPagerAdapter(
    activity: FragmentActivity,
    private val fragmentManager: FragmentManager
) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return fragmentManager.getFragment(position)
    }

    override fun getItemCount(): Int {
        return FragmentSteps.values().size
    }
}