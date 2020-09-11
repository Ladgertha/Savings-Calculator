package ru.ladgertha.savingscalculator.ui.base

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main_layout.*
import ru.ladgertha.savingscalculator.R

open class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val items =
            listOf(getString(R.string.days), getString(R.string.month), getString(R.string.year))
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        term_tv?.setAdapter(adapter)
    }

}