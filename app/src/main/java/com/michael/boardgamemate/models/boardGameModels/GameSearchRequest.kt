package com.michael.boardgamemate.models.boardGameModels

import com.michael.boardgamemate.models.boardGameModels.Game

data class GameSearchRequest(
    val games: List<Game>
)