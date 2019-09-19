package com.michael.boardgamemate.controllers

import android.app.Application
import androidx.lifecycle.LiveData
import com.michael.boardgamemate.db.GameDAO
import com.michael.boardgamemate.db.GamesDatabase
import com.michael.boardgamemate.interfaces.RequestListener
import com.michael.boardgamemate.models.boardGameModels.Game
import com.michael.boardgamemate.models.boardGameModels.GameSearchRequest
import com.prof.rssparser.OnTaskCompleted
import com.prof.rssparser.Parser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ApplicationRepository(application: Application)
{
    private var gameDao : GameDAO

    private var allUserGames : LiveData<List<Game>>

    private val retroController = RetroController

    private var parser: Parser

    private val rssUrl =
        "https://boardgamegeek.com/recentadditions/rss?subdomain=&infilters%5B0%5D=review&domain=boardgame"


    init {
        val database : GamesDatabase = GamesDatabase
            .getInstance(application.applicationContext)!!

        gameDao = database.gameDao()
        allUserGames = gameDao.getAllUserGames()

        parser = Parser()
    }


    fun insertGameToDb(game : Game)
    {
       GlobalScope.launch(Dispatchers.Default)
       {
           gameDao.insertNewGame(game)
       }
    }

    fun removeGameFromDb(game: Game)
    {
        GlobalScope.launch(Dispatchers.Default)
        {
            gameDao.removeGame(game.id)
        }
    }

    fun getAllGamesFromDb(): LiveData<List<Game>>
    {
        return allUserGames
    }


    fun findGames(name: String = "", publisher: String = "", requestListener: RequestListener<GameSearchRequest>)
    {
        retroController.searchGame(name,publisher,requestListener)
    }

    fun getArticlesFromRss(listenter: OnTaskCompleted)
    {
        parser.execute(rssUrl)

        parser.onFinish(listenter)
    }
}