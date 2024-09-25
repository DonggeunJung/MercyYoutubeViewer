/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.presentation.view.survey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vclip.mercy.R
import com.vclip.mercy.databinding.FragmentSurveyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SurveyFragment : Fragment() {
    private lateinit var binding: FragmentSurveyBinding
    private lateinit var fragment: Fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragment = this
        binding = FragmentSurveyBinding.inflate(inflater)

        binding.surveyComposeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    SurveyScreen (
                        onBackPressed = { parentFragmentManager.popBackStack() },
                        moveToMajorFragment = { findNavController().navigate(R.id.action_surveyFragment_to_majorFragment) }
                    )
                }
            }
        }
        return binding.root
    }
}