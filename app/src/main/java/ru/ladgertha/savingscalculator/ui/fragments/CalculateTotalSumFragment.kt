package ru.ladgertha.savingscalculator.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.ladgertha.savingscalculator.R
import ru.ladgertha.savingscalculator.databinding.FragmentCalculateTotalSumLayoutBinding
import ru.ladgertha.savingscalculator.ui.base.BaseFragment

class CalculateTotalSumFragment : BaseFragment(R.layout.fragment_calculate_total_sum_layout) {

    private var _binding: FragmentCalculateTotalSumLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCalculateTotalSumLayoutBinding.bind(view)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = CalculateTotalSumFragment()
    }
}