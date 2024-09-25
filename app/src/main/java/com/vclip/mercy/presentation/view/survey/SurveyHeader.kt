package com.vclip.mercy.presentation.view.survey

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vclip.mercy.R

@Composable
fun SurveyHeader(
    modifier: Modifier = Modifier,
    title: String,
    highlightedText: String,
    subtitle: String
) {
    Column(modifier = modifier) {
        val startIndex = title.indexOf(highlightedText)
        val endIndex = startIndex + highlightedText.length

        val builder = AnnotatedString.Builder(title).apply {
            addStyle(
                SpanStyle(color = colorResource(id = R.color.color_00c880)),
                startIndex,
                endIndex
            )
        }

        val annotatedString = builder.toAnnotatedString()

        Text(
            text = annotatedString,
            color = colorResource(id = R.color.color_1f2024),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.size(16.dp))

        Text(
            text = subtitle,
            color = colorResource(id = R.color.color_71727a),
            fontSize = 14.sp
        )
    }
}