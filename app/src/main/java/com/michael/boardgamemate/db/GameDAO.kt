package com.michael.boardgamemate.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.michael.boardgamemate.models.boardGameModels.Game

@Dao
interface GameDAO
{

    @Insert
    fun insertNewGame(game: Game)

    @Query("SELECT * FROM games_table")
    fun getAllUserGames(): LiveData<List<Game>>

    @Query("DELETE FROM games_table WHERE id = :gameId")
    fun removeGame(gameId: String)



}