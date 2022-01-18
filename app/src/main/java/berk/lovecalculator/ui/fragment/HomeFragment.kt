package berk.lovecalculator.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import berk.lovecalculator.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick() {
        with(binding) {
            btnGoToResult.setOnClickListener {
                val yourName = edtTextYourName.text.toString()
                val partnerName = edtTextPartnerName.text.toString()
                val action =
                    HomeFragmentDirections.actionHomeFragmentToResultFragment(yourName, partnerName)
                findNavController().navigate(action)
            }
        }
    }
}