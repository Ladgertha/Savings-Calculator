package ru.ladgertha.savingscalculator.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.ladgertha.savingscalculator.R
import ru.ladgertha.savingscalculator.databinding.FragmentMainLayoutBinding
import ru.ladgertha.savingscalculator.ui.base.BaseFragment
import ru.ladgertha.savingscalculator.view_models.MainViewModel
import java.lang.NumberFormatException
import java.lang.RuntimeException
import java.math.BigDecimal

class MainFragment : BaseFragment(R.layout.fragment_main_layout) {

    private val viewModel: MainViewModel by viewModel()
    private var _binding: FragmentMainLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainLayoutBinding.inflate(inflater, container, false)
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

    private fun setResultText(result: BigDecimal) {
        binding.mainFragmentMainHint.text =
            String.format(
                getString(R.string.main_fragment_sum_result),
                result.toString(),
                binding.mainFragmentSumEditText.text.toString(),
                resources.getQuantityString(
                    R.plurals.term_plurals_days,
                    binding.mainFragmentQuantityEditText.text.toString().toInt(),
                    binding.mainFragmentQuantityEditText.text.toString()
                )
            )
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
                viewModel.countSum(sum, term)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}