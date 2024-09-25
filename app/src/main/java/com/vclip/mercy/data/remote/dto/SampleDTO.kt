package com.vclip.mercy.data.remote.dto

import kotlinx.serialization.Serializable

//https://dog.ceo/api/breeds/image/random

//{
//    "message": "https://images.dog.ceo/breeds/mexicanhairless/n02113978_147.jpg",
//    "status": "success"
//}

@Serializable
data class SampleDTO(
    val message: String,
    val status: String
)
