package com.example.android.ktorchatapp.data.remote

import com.example.android.ktorchatapp.data.remote.dto.MessageDto
import com.example.android.ktorchatapp.domain.models.Message
import io.ktor.client.*
import io.ktor.client.request.*

class MessageServiceImpl(private val client: HttpClient) : MessageService {
    override suspend fun getAllMessages(): List<Message> {
        return try {
            client.get<List<MessageDto>>(MessageService.EndPoints.getAllMessages.url)
                .map { it.toMessage()}
        } catch (e: Exception){
            emptyList()
        }
    }
}