/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.presentation.view.onboarding

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vclip.mercy.common.Resource
import com.vclip.mercy.domain.entity.SampleData
import com.vclip.mercy.domain.usecase.GetSampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val getSampleUseCase: GetSampleUseCase
) : ViewModel() {

    private val _sampleData = MutableStateFlow<Resource<SampleData>>(Resource.Loading())
    val sampleData: StateFlow<Resource<SampleData>> = _sampleData.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = Resource.Loading()
    )

    private fun getOnBoarding() = viewModelScope.launch {
        getSampleUseCase.invoke().collect { values ->
            Log.d("OnBoardingViewModel","getSampleUseCase: $values")
            _sampleData.value = values
        }
    }

    init {
        getOnBoarding()
    }
}

