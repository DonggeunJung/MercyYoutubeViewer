package com.vclip.mercy.presentation.view.survey

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vclip.mercy.R

@Composable
fun SurveyInterestPage(
    modifier: Modifier = Modifier,
    interests: List<String> = listOf(),
    selectedInterests: List<String> = listOf(),
    onItemClicked: (String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        SurveyHeader(
            title = stringResource(id = R.string.survey_interest_title),
            highlightedText = "관심 분야",
            subtitle = stringResource(id = R.string.survey_interest_subtitle)
        )

        Spacer(modifier = Modifier.size(41.dp))

        interests.forEach {
            val isSelected = selectedInterests.contains(it)
            SelectableLineItem(
                text = it,
                isSelected = isSelected,
                modifier = Modifier
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) {
                        onItemClicked(it)
                    }
            )

            Spacer(modifier = Modifier.size(8.dp))
        }

        Spacer(modifier = Modifier.size(8.dp))
    }
}