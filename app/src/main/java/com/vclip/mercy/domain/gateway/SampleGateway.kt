/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.domain.gateway

import com.vclip.mercy.common.Resource
import com.vclip.mercy.domain.entity.SampleData
import kotlinx.coroutines.flow.Flow

//Note : define function what we need
interface SampleGateway {
    suspend fun getSampleData(): Flow<Resource<SampleData>>
    suspend fun getSampleDataFromRoom(id: Int): SampleData?
}