package ru.ladgertha.savingscalculator.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.ladgertha.savingscalculator.R
import ru.ladgertha.savingscalculator.databinding.FragmentCalculatePartialSumBinding
import ru.ladgertha.savingscalculator.ui.MainActivity
import ru.ladgertha.savingscalculator.ui.base.BaseFragment
import ru.ladgertha.savingscalculator.utils.TermsMapper
import ru.ladgertha.savingscalculator.utils.formatWithSpaces
import ru.ladgertha.savingscalculator.view_models.MainViewModel
import java.math.BigDecimal

class CalculatePartialSumFragment : BaseFragment(R.layout.fragment_calculate_partial_sum) {

    private val viewModel: MainViewModel by viewModel()
    private var _binding: FragmentCalculatePartialSumBinding? = null
    private val binding get() = _binding!!
    private val termsMapper: TermsMapper by inject {
        parametersOf(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculatePartialSumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter(binding.mainFragmentTermTv)
        binding.mainFragmentCountButton.setOnClickListener {
            count()
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.observeResultSumLiveData()
            .observe(viewLifecycleOwner, Observer {
                it.getContentIfNotHandled()?.let { result ->
                    setResultText(result)
                }
            })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val sum = binding.mainFragmentSumEditText.text.toString()
        if (sum.isNotEmpty()) {
            outState.putString(MainActivity.SUM, sum)
        }
        val term = binding.mainFragmentQuantityEditText.text.toString()
        if (term.isNotEmpty()) {
            outState.putString(MainActivity.TERM, term)
        }
        val result = binding.mainFragmentMainHint.text.toString()
        if (result.isNotEmpty()) {
            outState.putString(MainActivity.RESULT, result)
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let {
            val sum = savedInstanceState.getString(MainActivity.SUM)
            if (!sum.isNullOrEmpty()) {
                binding.mainFragmentSumEditText.setText(sum)
            }
            val term = savedInstanceState.getString(MainActivity.TERM)
            if (!term.isNullOrEmpty()) {
                binding.mainFragmentQuantityEditText.setText(term)
            }
            val result = savedInstanceState.getString(MainActivity.RESULT)
            if (!result.isNullOrEmpty()) {
                binding.mainFragmentMainHint.text = result
            }
        }
    }

    private fun setResultText(result: BigDecimal) {
        binding.mainFragmentMainHint.text =
            String.format(
                getString(R.string.calculate_partial_fragment_sum_result),
                result.toString().trimStart('0').formatWithSpaces(),
                binding.mainFragmentSumEditText.text.toString().trimStart('0').formatWithSpaces(),
                getTerm()
            )
    }

    private fun getTerm() = resources.getQuantityString(
        getTermId(),
        binding.mainFragmentQuantityEditText.text.toString().toInt(),
        binding.mainFragmentQuantityEditText.text.toString().trimStart('0').formatWithSpaces()
    )

    private fun getTermId(): Int {
        return when (binding.mainFragmentTermTv.text.toString()) {
            getString(R.string.days) -> R.plurals.term_plurals_days
            getString(R.string.month) -> R.plurals.term_plurals_months
            getString(R.string.year) -> R.plurals.term_plurals_years
            else -> R.plurals.term_plurals_days
        }
    }

    private fun count() {
        when {
            binding.mainFragmentSumEditText.text.isNullOrEmpty() ||
                    binding.mainFragmentSumEditText.text.toString() == "0" -> {
                showAlert(getString(R.string.alert_fill_sum), binding.mainFragmentCountButton)
            }
            binding.mainFragmentQuantityEditText.text.isNullOrEmpty() ||
                    binding.mainFragmentQuantityEditText.text.toString() == "0"
            -> {
                showAlert(getString(R.string.alert_fill_term), binding.mainFragmentCountButton)
            }
            else -> {
                val sum = binding.mainFragmentSumEditText.text.toString().toBigDecimal()
                val term = binding.mainFragmentQuantityEditText.text.toString().toBigDecimal()
                viewModel.countSum(
                    sum,
                    term,
                    termsMapper.mapStringToTerms(binding.mainFragmentTermTv.text.toString())
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}