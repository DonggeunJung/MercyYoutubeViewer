package com.vclip.mercy.presentation.view.survey

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.vclip.mercy.R
import com.vclip.mercy.presentation.view.appbar.AppBarLayout

const val MAX_PROGRESS = 4f

@Composable
fun SurveyScreen(
    onBackPressed: () -> Unit,
    moveToMajorFragment: () -> Unit
) {
    var currentProgress by remember { mutableStateOf(1) }

    val scrollState = rememberScrollState()

    val selectedInterests = remember { mutableStateListOf<String>() }
    val selectedKeywords = remember { mutableStateListOf<String>() }

    LaunchedEffect(currentProgress) {
        Log.d("Survey", "currentProgress: $currentProgress")
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        val (appBar, surveyArea, gradientMask, cta) = createRefs()

        AppBarLayout(
            modifier = Modifier
                .constrainAs(appBar) {
                    top.linkTo(parent.top)
                }
        ) {
            onBackPressed()
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .verticalScroll(scrollState)
                .constrainAs(surveyArea) {
                    top.linkTo(appBar.bottom, margin = 2.dp)
                    bottom.linkTo(cta.top)

                    height = Dimension.fillToConstraints
                }
        ) {
            Spacer(modifier = Modifier.size(24.dp))

            LinearProgressIndicator(
                progress = currentProgress / MAX_PROGRESS,
                color = colorResource(id = R.color.color_00c880),
                trackColor = colorResource(id = R.color.color_e8e9f1),
                strokeCap = StrokeCap.Round,
                modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp))
            )

            Spacer(modifier = Modifier.size(41.dp))

            when (currentProgress) {
                1 -> {
                    SurveyInterestPage(
                        interests = listOf(
                            "Education 교육",
                            "Science & Technology 과학/기술",
                            "Lifestyle 라이프스타일",
                            "Travel 여행",
                            "Movies & Animation 영화/애니",
                            "Entertainment 엔터테인먼트",
                            "Pets & Animals 애완동물",
                            "Game 게임"),
                        selectedInterests = selectedInterests,
                        onItemClicked = {
                            if (selectedInterests.contains(it)) {
                                selectedInterests.remove(it)
                            } else {
                                if (selectedInterests.size < 3) {
                                    selectedInterests.add(it)
                                    Log.d("Survey", "selectedInterests: $selectedInterests")
                                } else {
                                    Log.d("Survey", "too many")
                                }
                            }
                        }
                    )
                }

                2 -> {
                    SurveyKeywordPage(
                        keywords = listOf(
                            "외국어",
                            "금융/재테크",
                            "독서",
                            "자기개발",
                            "자격증",
                            "IT기술",
                            "영유아교육",
                            "수능",
                            "데이터 사이언스",
                            "프로그래밍",
                            "인공지능(AI)",
                            "코딩",
                            "딥러닝",
                            "ChatGPT",
                            "인간관계",
                            "뷰티",
                            "요리",
                            "홈트",
                            "심리",
                            "패션",
                            "해외 여행",
                            "국내 여행",
                            "여행 꿀팁",
                            "애니메이션",
                            "한국 영화",
                            "외국 영화",
                            "시사/교양",
                            "스포츠",
                            "예능",
                            "팟캐스트",
                            "반려동물",
                            "강아지",
                            "고양이"
                        ),
                        selectedKeywords = selectedKeywords,
                        onItemClicked = {
                            if (selectedKeywords.contains(it)) {
                                selectedKeywords.remove(it)
                            } else {
                                if (selectedKeywords.size < 3) {
                                    selectedKeywords.add(it)
                                    Log.d("Survey", "selectedKeywords: $selectedKeywords")
                                } else {
                                    Log.d("Survey", "too many")
                                }
                            }
                        }
                    )
                }

                3 -> {

                }

                4 -> {
                    moveToMajorFragment()
                }
            }
        }

        Box(
            modifier = Modifier
                .height(37.dp)
                .fillMaxWidth()
                .background(Brush.verticalGradient(listOf(Color.Transparent, Color.White)))
                .constrainAs(gradientMask) {
                    bottom.linkTo(cta.top)
                }
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(87.dp)
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.white))
                .padding(start = 24.dp, end = 24.dp, top = 15.dp, bottom = 24.dp)
                .constrainAs(cta) {
                    bottom.linkTo(parent.bottom)
                }
        ) {
            val btnEnable:Boolean = when(currentProgress) {
                1 -> selectedInterests.size >= 3
                2 -> selectedKeywords.size >= 1
                else -> true
            }
            val btnBackColor = if(btnEnable) R.color.color_00c880 else R.color.color_adadad
            Button(
                onClick = { currentProgress++ },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxSize(),
                colors = ButtonDefaults.buttonColors(colorResource(id = btnBackColor)),
                enabled = btnEnable
            ) {
                Text(text = stringResource(id = R.string.next))
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
fun SurveyPreview() {
    SurveyScreen(
        onBackPressed = {},
        moveToMajorFragment = {}
    )
}