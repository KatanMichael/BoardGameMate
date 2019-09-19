package com.michael.boardgamemate.interfaces

import com.michael.boardgamemate.models.boardGameModels.GameSearchRequest
import com.michael.boardgamemate.models.boardGameModels.ImageRequest
import com.michael.boardgamemate.models.boardGameModels.RandomGame
import com.michael.boardgamemate.models.boardGameModels.VideoRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataRetro
{
    @GET("/api/search")
    fun searchGame(@Query("client_id") clientId : String,
                   @Query("name") name: String = "",
                   @Query("publisher")publisher: String = "") : Call<GameSearchRequest>

    @GET("/api/search")
    fun getRandomGame(@Query("client_id") clientId : String,
                      @Query("random") random : String = "true") : Call<RandomGame>


    @GET("/api/game/images")
    fun getImagesByGameId(@Query("client_id") clientId : String,
                          @Query("game_id")game_id: String,
                          @Query("limit") limit: String = "100"): Call<ImageRequest>


    @GET("/api/game/videos")
    fun getVideosByGameId(@Query("client_id") clientId : String,
                          @Query("game_id")game_id: String,
                          @Query("limit") limit: String = "100"): Call<VideoRequest>
}