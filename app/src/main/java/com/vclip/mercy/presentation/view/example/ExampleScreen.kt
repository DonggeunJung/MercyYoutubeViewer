package com.vclip.mercy.presentation.view.example

import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.vclip.mercy.R
import com.vclip.mercy.databinding.ExampleScreenBinding

@Composable
fun ExampleScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_700))
    ) {
        val context = LocalContext.current

        AndroidViewBinding(ExampleScreenBinding::inflate) {
            exampleButton.setOnClickListener {
                it.visibility = View.GONE
                exampleTextView.text = context.getText(R.string.hello_world)
            }
        }
    }
}