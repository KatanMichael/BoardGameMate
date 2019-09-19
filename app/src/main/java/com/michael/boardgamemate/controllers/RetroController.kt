package com.michael.boardgamemate.controllers

import com.michael.boardgamemate.interfaces.*
import com.michael.boardgamemate.interfaces.GetDataRetro
import com.michael.boardgamemate.models.boardGameModels.GameSearchRequest
import com.michael.boardgamemate.models.boardGameModels.ImageRequest
import com.michael.boardgamemate.models.boardGameModels.RandomGame
import com.michael.boardgamemate.models.boardGameModels.VideoRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

object RetroController
{
    private val client_id = "drPWgblet0"
    private val baseUrl = "https://www.boardgameatlas.com"

    private val retrofit = Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()

    private var retroClient = retrofit.create(GetDataRetro::class.java)



    fun searchGame(name: String = "", publisher: String = "", requestListener: RequestListener<GameSearchRequest>)
    {
        retroClient.searchGame(client_id
                ,name,publisher).enqueue(object : Callback<GameSearchRequest>
        {
            override fun onFailure(call: Call<GameSearchRequest>, t: Throwable)
            {
                if(t.message != null)
                {
                    requestListener.onError(t.message.toString())
                }
            }

            override fun onResponse(call: Call<GameSearchRequest>, response: Response<GameSearchRequest>)
            {
                val body = response.body()

               if(body != null)
               {
                   requestListener.onComplete(body)
               }
            }

        })

    }

    fun getRandomGame(requestListener: RequestListener<RandomGame>)
    {
        retroClient.getRandomGame(client_id)
                .enqueue(object : Callback<RandomGame>{
                    override fun onResponse(call: Call<RandomGame>, response: Response<RandomGame>)
                    {
                        val body = response.body()
                        if(body != null)
                        {
                            requestListener.onComplete(body)
                        }else
                        {
                            onFailure(call, Throwable("Body Is Null"))
                        }
                    }

                    override fun onFailure(call: Call<RandomGame>, t: Throwable)
                    {
                        requestListener.onError(t.message.toString())

                    }


                })

    }

    fun getImagesByGameId(gameId: String,limit: String = "" , requestListener: RequestListener<ImageRequest>)
    {
        retroClient.getImagesByGameId(client_id,gameId,limit)
                .enqueue(object : Callback<ImageRequest>
                {
                    override fun onFailure(call: Call<ImageRequest>, t: Throwable)
                    {
                        requestListener.onError(t.message.toString())
                    }

                    override fun onResponse(call: Call<ImageRequest>, response: Response<ImageRequest>)
                    {
                        val body = response.body()
                        if(body != null)
                        {
                            requestListener.onComplete(body)
                        }else
                        {
                            onFailure(call,Throwable("Body Is Null"))
                        }
                    }

                })

    }

    fun getVideosByGameId(gameId: String,limit: String = "" , requestListener: RequestListener<VideoRequest>)
    {
        retroClient.getVideosByGameId(client_id,gameId,limit)
                .enqueue(object : Callback<VideoRequest>
                {
                    override fun onFailure(call: Call<VideoRequest>, t: Throwable)
                    {
                        requestListener.onError(t.message.toString())
                    }

                    override fun onResponse(call: Call<VideoRequest>, response: Response<VideoRequest>)
                    {
                        val body = response.body()
                        if(body != null)
                        {
                            requestListener.onComplete(body)
                        }else
                        {
                            onFailure(call,Throwable("Body Is Null"))
                        }
                    }
                })

    }
}
