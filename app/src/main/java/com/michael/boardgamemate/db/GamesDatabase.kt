package com.michael.boardgamemate.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.michael.boardgamemate.models.boardGameModels.Game

@Database(entities = [Game::class],version = 1)
abstract class GamesDatabase : RoomDatabase()
{
    abstract fun gameDao(): GameDAO

    companion object
    {
        private var instance : GamesDatabase? = null

        fun getInstance(context: Context): GamesDatabase?
        {
            if (instance == null)
            {
                synchronized(GamesDatabase::class.java)
                {
                    instance = Room
                        .databaseBuilder(context.applicationContext,
                            GamesDatabase::class.java,
                            "game_database")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return instance
        }
    }

}