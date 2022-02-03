package com.example.android.ktorchatapp.data.remote

import com.example.android.ktorchatapp.domain.models.Message

interface MessageService {
    suspend fun getAllMessages() : List<Message>

    companion object {
        const val BASE_URL = "http://10.0.2.2:8080"
    }

    sealed class EndPoints(val url: String) {
        object getAllMessages: EndPoints("$BASE_URL/messages")
    }
}