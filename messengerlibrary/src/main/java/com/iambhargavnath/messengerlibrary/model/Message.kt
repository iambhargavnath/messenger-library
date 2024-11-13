package com.iambhargavnath.messengerlibrary.model

data class Message(
    val content: String,
    val sender: String,
    val time: String? = null,
    val profilePicUrl: String? = null
)
