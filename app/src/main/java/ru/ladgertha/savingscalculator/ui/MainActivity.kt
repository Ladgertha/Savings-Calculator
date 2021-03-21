package ru.ladgertha.savingscalculator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.analytics.FirebaseAnalytics
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import ru.ladgertha.savingscalculator.adapter.FragmentManager
import ru.ladgertha.savingscalculator.adapter.ViewPagerAdapter
import ru.ladgertha.savingscalculator.databinding.ActivityMainLayoutBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainLayoutBinding

    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    private val viewPagerAdapter: ViewPagerAdapter by inject {
        parametersOf(this)
    }

    private val fragmentManager: FragmentManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLayoutBinding.inflate(layoutInflater)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(
            binding.tabLayoutFragments,
            binding.viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = getString(fragmentManager.getTitle(position))
        }.attach()
    }

    companion object {
        const val TERM = "TERM"
        const val SUM = "SUM"
        const val RESULT = "RESULT"
    }
}

