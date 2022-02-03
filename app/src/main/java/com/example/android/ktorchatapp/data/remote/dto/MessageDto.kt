package com.example.android.ktorchatapp.data.remote.dto

import com.example.android.ktorchatapp.domain.models.Message
import kotlinx.serialization.Serializable
import java.text.DateFormat
import java.util.*

@Serializable
data class MessageDto(
    val text: String,
    val username: String,
    val timestamp: Long,
    val id: String
) {
    fun toMessage(): Message {
        val date = Date(timestamp)
        val formattedDate = DateFormat
            .getDateInstance(DateFormat.DEFAULT, Locale.getDefault())
            .format(date)
        return Message(
            text = text,
            username = username,
            formattedTime = formattedDate
        )
    }
}