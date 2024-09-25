package com.vclip.mercy.presentation.view.survey

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vclip.mercy.R

@Composable
fun SelectableKeywordItem(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
) {
    val backgroundModifier =
        if (isSelected) Modifier.background(colorResource(id = R.color.gray_333))
        else Modifier

    val borderModifier =
        if (isSelected) Modifier
        else Modifier.border(
            width = 0.5.dp,
            color = colorResource(id = R.color.color_c5c6cc),
            shape = RoundedCornerShape(22.dp)
        )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(44.dp)
            .clip(RoundedCornerShape(22.dp))
            .then(backgroundModifier)
            .then(borderModifier)
            .padding(horizontal = 26.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            color = colorResource(id = if (isSelected) R.color.white else R.color.black),
            fontWeight = FontWeight.W700,
            fontSize = 14.sp
        )
    }
}

@Preview(
    showBackground = true, backgroundColor = 0xFFF
)
@Composable
fun SelectableKeywordPreview1() {
    SelectableKeywordItem(text = "외국어", isSelected = false)
}

@Preview(
    showBackground = true, backgroundColor = 0xFFF
)
@Composable
fun SelectableKeywordPreview2() {
    SelectableKeywordItem(text = "외국어", isSelected = true)
}