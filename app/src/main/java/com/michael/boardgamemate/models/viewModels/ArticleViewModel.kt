package com.michael.boardgamemate.models.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prof.rssparser.Article

class ArticleViewModel(application: Application) :AndroidViewModel(application)
{
    private var newsArticles = MutableLiveData<List<Article>>()

    fun updateNews(list: List<Article>)
    {
        newsArticles.postValue(list)
    }

    fun getNews(): LiveData<List<Article>>
    {
        return newsArticles
    }

}