/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.presentation.view.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.vclip.mercy.R
import com.vclip.mercy.databinding.FragmentWelcomeBinding
import com.vclip.mercy.presentation.base.BaseFragment

class WelcomeFragment : BaseFragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater)
        return binding.root
    }

    override fun setupListeners() {
        binding.btConfirm.setOnClickListener {
            findNavController().navigate(
                R.id.action_welcomeFragment_to_surveyFragment)
        }
    }
}