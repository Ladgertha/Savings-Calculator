package ru.ladgertha.savingscalculator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ru.ladgertha.savingscalculator.FragmentManager
import ru.ladgertha.savingscalculator.R
import ru.ladgertha.savingscalculator.adapter.ViewPagerAdapter
import ru.ladgertha.savingscalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(
            binding.tabLayoutFragments, binding.viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            val title = getString(FragmentManager().getTitle(position))
            tab.text = title
        }.attach()
    }
}

