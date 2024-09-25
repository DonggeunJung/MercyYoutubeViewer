/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.data

/**
 * GatewayImpl 에서 사용할 service(api) url 선언
 */
object EndPoint {
    private const val BASE_URL = "https://dog.ceo/"

    //TODO : add description and DTO name
    // DTO : SampleDTO
    const val SAMPLE_URL = BASE_URL + "api/breeds/image/random"
}