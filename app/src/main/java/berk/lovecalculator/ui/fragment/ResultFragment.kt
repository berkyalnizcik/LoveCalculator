package berk.lovecalculator.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import berk.lovecalculator.R
import berk.lovecalculator.databinding.FragmentResultBinding
import berk.lovecalculator.ui.viewmodel.ResultViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : BaseFragment<FragmentResultBinding>(FragmentResultBinding::inflate) {

    private val args: ResultFragmentArgs by navArgs()
    private val viewModel: ResultViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        onNavigate()
    }

    private fun initUI() {
        viewModel.getResult(
            args.yourName,
            args.partnerName
        )
        with(binding) {
            viewModel.getResultLiveData.observe(viewLifecycleOwner) { response ->
                (response.percentage + getString(R.string.percentage)).also { tvPercent.text = it }
                tvResult.text = response.result
                tvYourName.text = response.yourName
                tvPartnerName.text = response.partnerName
            }
        }
    }

    private fun onNavigate() {
        binding.btnGoToHome.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
        }
    }
}