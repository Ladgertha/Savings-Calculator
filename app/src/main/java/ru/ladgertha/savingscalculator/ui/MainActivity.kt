package ru.ladgertha.savingscalculator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_layout.*
import ru.ladgertha.savingscalculator.R
import ru.ladgertha.savingscalculator.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout)
        setSupportActionBar(toolbar)

        view_pager.adapter = ViewPagerAdapter(supportFragmentManager)
        tab_layout_fragments.setupWithViewPager(view_pager)
    }
}