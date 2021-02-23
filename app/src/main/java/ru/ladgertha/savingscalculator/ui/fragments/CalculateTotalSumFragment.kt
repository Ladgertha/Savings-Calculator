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
import ru.ladgertha.savingscalculator.databinding.FragmentCalculateTotalSumBinding
import ru.ladgertha.savingscalculator.ui.base.BaseFragment
import ru.ladgertha.savingscalculator.utils.TermsMapper
import ru.ladgertha.savingscalculator.utils.formatWithSpaces
import ru.ladgertha.savingscalculator.view_models.MainViewModel
import java.math.BigDecimal

class CalculateTotalSumFragment : BaseFragment(R.layout.fragment_calculate_total_sum) {

    private val viewModel: MainViewModel by viewModel()
    private var _binding: FragmentCalculateTotalSumBinding? = null
    private val binding get() = _binding!!
    private val termsMapper: TermsMapper by inject {
        parametersOf(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculateTotalSumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter(binding.calculateFragmentTermTv)

        binding.calculateFragmentCountButton.setOnClickListener {
            count()
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.observeResultTermLiveData()
            .observe(viewLifecycleOwner, Observer {
                it.getContentIfNotHandled()?.let { result ->
                    setResultText(result)
                }
            })
    }

    private fun setResultText(result: BigDecimal) {
        binding.calculateFragmentCalculateHint.text =
            String.format(
                getString(R.string.calculate_sum_fragment_text_sum_result),
                binding.calculateFragmentSumEditText.text.toString().trimStart('0').formatWithSpaces(),
                getTerm(),
                result.toString().trimStart('0').formatWithSpaces()
            )
    }

    private fun getTerm() = resources.getQuantityString(
        getTermId(),
        binding.calculateFragmentQuantityEditText.text.toString().toInt(),
        binding.calculateFragmentQuantityEditText.text.toString().trimStart('0').formatWithSpaces()
    )

    private fun getTermId(): Int {
        return when (binding.calculateFragmentTermTv.text.toString()) {
            getString(R.string.days) -> R.plurals.sum_plurals_days
            getString(R.string.month) -> R.plurals.sum_plurals_months
            getString(R.string.year) -> R.plurals.sum_plurals_years
            else -> R.plurals.sum_plurals_days
        }
    }

    private fun count() {
        when {
            binding.calculateFragmentSumEditText.text.isNullOrEmpty() ||
                    binding.calculateFragmentSumEditText.text.toString() == "0" -> {
                showAlert(getString(R.string.alert_fill_sum), binding.calculateFragmentCountButton)
            }
            binding.calculateFragmentQuantityEditText.text.isNullOrEmpty() ||
                    binding.calculateFragmentQuantityEditText.text.toString() == "0" -> {
                showAlert(getString(R.string.alert_fill_term), binding.calculateFragmentCountButton)
            }
            else -> {
                val sum = binding.calculateFragmentSumEditText.text.toString().toBigDecimal()
                val term = binding.calculateFragmentQuantityEditText.text.toString().toBigDecimal()
                viewModel.countTerm(
                    sum,
                    term,
                    termsMapper.mapStringToTerms(binding.calculateFragmentTermTv.text.toString())
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}