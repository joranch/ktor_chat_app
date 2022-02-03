package com.example.android.ktorchatapp.di

import com.example.android.ktorchatapp.data.remote.ChatSocketService
import com.example.android.ktorchatapp.data.remote.ChatSocketServiceImpl
import com.example.android.ktorchatapp.data.remote.MessageService
import com.example.android.ktorchatapp.data.remote.MessageServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.websocket.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideHttpClient() : HttpClient{
        return HttpClient(CIO){
            install(Logging)
            install(WebSockets)
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }
    }

    @Provides
    @Singleton
    fun provideMessageService(client: HttpClient) : MessageService {
        return MessageServiceImpl(client)
    }

    @Provides
    @Singleton
    fun provideChatSocketService(client: HttpClient) : ChatSocketService {
        return ChatSocketServiceImpl(client)
    }
}