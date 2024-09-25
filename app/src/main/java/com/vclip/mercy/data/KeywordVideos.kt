package com.vclip.mercy.data

data class KeywordVideos(
    val keyword: String = "",
    val iconId: Int = 0,
    val videos: MutableList<YtVideo> = mutableListOf()
)