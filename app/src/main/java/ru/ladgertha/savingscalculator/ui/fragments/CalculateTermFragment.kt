package ru.ladgertha.savingscalculator.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.ladgertha.savingscalculator.R
import ru.ladgertha.savingscalculator.databinding.FragmentCalculateTermBinding
import ru.ladgertha.savingscalculator.ui.base.BaseFragment
import ru.ladgertha.savingscalculator.view_models.MainViewModel
import java.math.BigDecimal

class CalculateTermFragment : BaseFragment(R.layout.fragment_calculate_term) {

    private val viewModel: MainViewModel by viewModel()
    private var _binding: FragmentCalculateTermBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculateTermBinding.inflate(inflater, container, false)
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
                getString(R.string.calculate_fragment_text_sum_result),
                binding.calculateFragmentSumEditText.text.toString(),
                resources.getQuantityString(
                    R.plurals.sum_plurals_days,
                    binding.calculateFragmentQuantityEditText.text.toString().toInt(),
                    binding.calculateFragmentQuantityEditText.text.toString()
                ),
                result.toString()
            )
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
                viewModel.countTerm(sum, term)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}