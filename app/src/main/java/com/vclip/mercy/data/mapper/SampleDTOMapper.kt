/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.data.mapper

import com.vclip.mercy.data.local.SampleEntity
import com.vclip.mercy.data.remote.dto.SampleDTO
import com.vclip.mercy.domain.entity.SampleData

fun SampleDTO.toSampleData(): SampleData {
    return SampleData(
        id = 1, title = status, imageUrl = message
    )
}
fun SampleEntity.toSampleData(): SampleData {
    return SampleData(
        id = 1, title = title, imageUrl = imageUrl
    )
}