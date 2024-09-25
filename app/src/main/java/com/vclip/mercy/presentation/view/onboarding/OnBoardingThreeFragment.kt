/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.presentation.view.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.vclip.mercy.R
import com.vclip.mercy.databinding.FragmentOnboardingThreeBinding
import com.vclip.mercy.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingThreeFragment : BaseFragment() {
    private lateinit var binding: FragmentOnboardingThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingThreeBinding.inflate(inflater)
        return binding.root
    }

    override fun setupListeners() {
        binding.btNext.setOnClickListener {
            findNavController().navigate(
                R.id.action_onBoardingThreeFragment_to_signInFragment)
        }
    }
}