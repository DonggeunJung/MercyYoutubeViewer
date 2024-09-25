/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.presentation.view.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.vclip.mercy.R
import com.vclip.mercy.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    // Assuming you have a ProgressBar variable named progressBar
    private val progressBarMaxValue = 100 // Set the maximum value of the ProgressBar
    private val durationInMillis = 1000L // Set the duration in milliseconds (1 second)
    private val updateInterval = 10L // Set the interval for updating the ProgressBar (10 milliseconds)

    private val progressIncrement = progressBarMaxValue * updateInterval / durationInMillis

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        handleProgressBar()
    }

    private fun handleProgressBar() {
        lifecycleScope.launch {
            var progress = 0

            while (progress < progressBarMaxValue) {
                // Update the progress value
                progress += progressIncrement.toInt()

                // Set the progress value to the ProgressBar
                binding.progressBar.progress = progress

                delay(updateInterval)
            }
            //go to next page
            findNavController().navigate(
                R.id.action_splashFragment_to_onBoardingFragment
            )
        }
    }
}