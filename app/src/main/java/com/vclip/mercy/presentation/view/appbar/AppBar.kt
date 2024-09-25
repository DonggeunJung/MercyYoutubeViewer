package com.vclip.mercy.presentation.view.appbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vclip.mercy.R

@Composable
fun AppBarLayout(
    modifier: Modifier = Modifier,
    title: String = "",
    onBackClicked: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(52.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "back",
            modifier = Modifier
                .clickable { onBackClicked() }
        )
    }

}

@Preview
@Composable
fun AppBarPreview() {
    AppBarLayout()
}