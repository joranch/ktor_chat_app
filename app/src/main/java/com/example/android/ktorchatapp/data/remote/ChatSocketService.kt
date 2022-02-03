package com.example.android.ktorchatapp.data.remote

import com.example.android.ktorchatapp.domain.models.Message
import com.example.android.ktorchatapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {
    suspend fun initSession(username: String) : Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages() : Flow<Message>

    suspend fun closeSession()

    companion object {
        const val BASE_URL = "ws://10.0.2.2:8080"
    }

    sealed class EndPoints(val url: String) {
        object ChatSocket: EndPoints("$BASE_URL/chat-socket")
    }
}