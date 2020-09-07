package ru.ladgertha.savingscalculator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main_layout.*
import ru.ladgertha.savingscalculator.R
import ru.ladgertha.savingscalculator.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout)
        setSupportActionBar(toolbar)

        view_pager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(
            tab_layout_fragments, view_pager
        ) { tab: TabLayout.Tab, i: Int ->
            val title = when (i) {
                0 -> {
                    "Main"
                }
                1 -> {
                    "Second"
                }
                else -> {
                    // TODO Add error
                    "Unknown"
                }
            }
            tab.text = title
        }.attach()
    }
}

