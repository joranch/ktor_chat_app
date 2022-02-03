package com.example.android.ktorchatapp.domain.models

data class Message(
    val text: String,
    val username: String,
    val formattedTime: String,
)