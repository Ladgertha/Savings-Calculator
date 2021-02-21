package ru.ladgertha.savingscalculator.adapter

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    activity: FragmentActivity,
    private val fragmentManager: FragmentManager
) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return fragmentManager.getFragment(position)
    }

    override fun getItemCount(): Int {
        return FRAGMENTS_COUNT
    }

    companion object {
        private const val FRAGMENTS_COUNT = 2
    }
}