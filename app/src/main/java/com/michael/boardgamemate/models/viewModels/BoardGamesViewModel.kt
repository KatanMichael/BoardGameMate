package com.michael.boardgamemate.models.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.michael.boardgamemate.controllers.ApplicationRepository
import com.michael.boardgamemate.models.boardGameModels.Game

class BoardGamesViewModel(application: Application)
    : AndroidViewModel(application)
{
    var applicationRepository = ApplicationRepository(application)

    private var allUserGames : LiveData<List<Game>>
            = applicationRepository.getAllGamesFromDb()


    fun insertGame(game: Game)
    {
        applicationRepository.insertGameToDb(game)
    }



}