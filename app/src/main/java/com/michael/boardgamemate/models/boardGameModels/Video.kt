package com.michael.boardgamemate.models.boardGameModels

import com.michael.boardgamemate.models.boardGameModels.Game

data class Video(
    val channel_name: String,
    val created_at: String,
    val game: Game,
    val id: String,
    val image_url: String,
    val published_date: String,
    val thumb_url: String,
    val title: String,
    val url: String,
    val views: Int
)