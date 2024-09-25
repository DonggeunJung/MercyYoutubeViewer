package com.vclip.mercy.presentation.view.survey

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.vclip.mercy.R

@Composable
fun SelectableLineItem(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean
) {
    val backgroundModifier =
        if (isSelected) Modifier.background(colorResource(id = R.color.gray_333))
        else Modifier

    val borderModifier =
        if (isSelected) Modifier
        else Modifier.border(
            width = 0.5.dp,
            color = colorResource(id = R.color.color_c5c6cc),
            shape = RoundedCornerShape(12.dp)
        )

    ConstraintLayout(
        modifier = modifier
            .height(52.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .then(backgroundModifier)
            .then(borderModifier)
    ) {
        val (title, checkMark) = createRefs()

        Text(text = text,
            color = colorResource(id = if (isSelected) R.color.white else R.color.color_1f2024),
            fontSize = 14.sp,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)

                start.linkTo(parent.start, margin = 16.dp)
            })

        if (isSelected) {
            Icon(painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "check mark",
                tint = colorResource(id = R.color.white),
                modifier = Modifier.constrainAs(checkMark) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)

                    end.linkTo(parent.end, margin = 16.dp)
                })
        }
    }
}

@Preview(
    showBackground = true, backgroundColor = 0xFFF
)
@Composable
fun SelectableLineItemPreview1() {
    SelectableLineItem(text = "Science & Technology 과학/기술", isSelected = false)
}

@Preview(
    showBackground = true, backgroundColor = 0xFFF
)
@Composable
fun SelectableLineItemPreview2() {
    SelectableLineItem(text = "Science & Technology 과학/기술", isSelected = true)
}