/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    /**
     * Override to setup listeners
     */
    protected open fun setupListeners() {}

    /**
     * Override to setup observers for view models
     */
    protected open fun subscribeToViewModels() {}

    /**
     * Use this as reference for all fragments
     */
    protected lateinit var parentActivity : BaseActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity = context as BaseActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    override fun onStart() {
        super.onStart()
        subscribeToViewModels()
    }
}