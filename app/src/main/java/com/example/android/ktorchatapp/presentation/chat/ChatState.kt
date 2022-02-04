package com.example.android.ktorchatapp.presentation.chat

import com.example.android.ktorchatapp.domain.models.Message

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)
