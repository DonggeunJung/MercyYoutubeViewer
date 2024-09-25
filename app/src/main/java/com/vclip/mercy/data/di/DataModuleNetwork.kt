/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.data.di

import android.app.Application
import androidx.room.Room
import com.vclip.mercy.data.local.SampleDao
import com.vclip.mercy.data.local.SampleDatabase
import com.vclip.mercy.data.repository.SampleGatewayImpl
import com.vclip.mercy.domain.gateway.SampleGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModuleNetwork {

    @OptIn(ExperimentalSerializationApi::class)
    private val json: Json = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
        explicitNulls = true
    }

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(json)
            }
        }
    }

    @Provides
    @Singleton
    fun provideSampleDatabase(app: Application): SampleDatabase {
        return Room.databaseBuilder(
            app,
            SampleDatabase::class.java,
            "mercy_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideSampleDao(sampleDatabase: SampleDatabase): SampleDao {
        return sampleDatabase.sampleDao
    }

    //NOTE : add GatewayImpl
    @Provides
    @Singleton
    fun provideSampleRepository(
        httpClient: HttpClient,
        sampleDao: SampleDao
    ): SampleGateway {
        return SampleGatewayImpl(httpClient, sampleDao)
    }
}