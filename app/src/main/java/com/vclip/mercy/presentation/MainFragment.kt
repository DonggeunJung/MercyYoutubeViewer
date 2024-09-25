/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.vclip.mercy.R
import com.vclip.mercy.databinding.FragmentMainBinding
import com.vclip.mercy.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun setupListeners() {
        binding.btnOneByOne.setOnClickListener {
            findNavController().navigate(
                R.id.action_mainFragment_to_splashFragment)
        }
        binding.btnTwoByOne.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_splashFragment)
        }
    }

}