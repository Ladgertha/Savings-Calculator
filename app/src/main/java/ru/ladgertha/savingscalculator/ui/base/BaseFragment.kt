package ru.ladgertha.savingscalculator.ui.base

import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import ru.ladgertha.savingscalculator.R

open class BaseFragment(layout: Int) : Fragment(layout) {

    fun setAdapter(view: AutoCompleteTextView) {
        val items =
            listOf(getString(R.string.days))
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        view.setAdapter(adapter)
    }

    fun showAlert(text: String, view: View) {
        with(Snackbar.make(view, text, Snackbar.LENGTH_SHORT)) {
            setBackgroundTint(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.snack_bar_background
                )
            )
            setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.snack_bar_text_color
                )
            )
            show()
        }
    }

}