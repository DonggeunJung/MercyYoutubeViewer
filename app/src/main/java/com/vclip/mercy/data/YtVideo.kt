package com.vclip.mercy.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.Calendar

@Parcelize
data class YtVideo(
    val id: String,
    val title: String,
    val author: String,
    val date: Long = Calendar.getInstance().timeInMillis,
    val hits: Int = 99,
    val thumbnailURL: String = "",
    val startSeconds: Int = 0
) : Parcelable {
    fun thumbnailURL(): String {
        if(thumbnailURL.isNullOrEmpty()) {
            return "https://img.youtube.com/vi/$id/mqdefault.jpg"
        }
        return thumbnailURL
    }
}