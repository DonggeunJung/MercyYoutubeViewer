package com.vclip.mercy.presentation.view.survey

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vclip.mercy.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SurveyKeywordPage(
    modifier: Modifier = Modifier,
    keywords: List<String> = listOf(),
    selectedKeywords: List<String> = listOf(),
    onItemClicked: (String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        SurveyHeader(
            title = stringResource(id = R.string.survey_keyword_title),
            highlightedText = "키워드",
            subtitle = stringResource(id = R.string.survey_keyword_subtitle)
        )

        Spacer(modifier = Modifier.size(41.dp))

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            keywords.forEach {
                Box(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                ) {
                    val isSelected = selectedKeywords.contains(it)
                    SelectableKeywordItem(
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
                }
            }
        }

        Spacer(modifier = Modifier.size(8.dp))
    }
}