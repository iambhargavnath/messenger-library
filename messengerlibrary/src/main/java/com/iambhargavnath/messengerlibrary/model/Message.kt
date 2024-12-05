package com.iambhargavnath.messengerlibrary.model

data class Message(
    val id: String? = null,
    val content: String,
    val sender: String,
    val receiver: String? = null,
    val time: String? = null,
    val profilePicUrl: String? = null
)
