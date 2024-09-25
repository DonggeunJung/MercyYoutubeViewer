/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "mercy_db")
data class SampleEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val imageUrl: String
)