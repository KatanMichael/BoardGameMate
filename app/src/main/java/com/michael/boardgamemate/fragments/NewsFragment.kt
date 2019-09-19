package com.michael.boardgamemate.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.michael.boardgamemate.R
import com.michael.boardgamemate.adapters.NewsAdapter
import com.michael.boardgamemate.controllers.ApplicationRepository
import com.michael.boardgamemate.interfaces.OnItemClickListener
import com.michael.boardgamemate.models.viewModels.ArticleViewModel
import com.prof.rssparser.Article
import com.prof.rssparser.OnTaskCompleted
import kotlinx.android.synthetic.main.news_fragment.*

class NewsFragment : Fragment(), OnItemClickListener<Article>
{

    val TAG = "BoardGameTag"

    lateinit var repository: ApplicationRepository

    lateinit var navController: NavController

    companion object {
        fun newInstance() = NewsFragment()
    }

    private lateinit var viewModel: ArticleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {

        viewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)

        navController = this.findNavController()

        var articales = ArrayList<Article>()

        var newAdapter = NewsAdapter(this.context,articales)

        newAdapter.setClickListener(this)

        newsRecycleView.adapter = newAdapter
        newsRecycleView.layoutManager = LinearLayoutManager(this.context)

        viewModel.getNews().observe(this, Observer {

            newAdapter.setlist(it)
        })

        repository = ApplicationRepository(this.activity!!.application)

        repository.getArticlesFromRss(object : OnTaskCompleted
        {
            override fun onTaskCompleted(list: MutableList<Article>)
            {
                //Log.d(TAG,list.toString())
                viewModel.updateNews(list)
            }

            override fun onError(e: Exception)
            {
                Log.d(TAG,"Error: ${e.message}")
            }

        })

        swiperefreshNewsFragment.setOnRefreshListener {
            repository.getArticlesFromRss(object : OnTaskCompleted {
                override fun onTaskCompleted(list: MutableList<Article>) {
                    //Log.d(TAG,list.toString())
                    viewModel.updateNews(list)
                    swiperefreshNewsFragment.isRefreshing = false
                }

                override fun onError(e: Exception) {
                    Log.d(TAG,"Error: ${e.message}")
                }

            })
        }
    }

    override fun onItemClick(article: Article)
    {
        var bundle = bundleOf("title" to article.title, "author" to article.author,
            "content" to article.description)
        navController.navigate(R.id.action_newsFragment_to_articleViewFragment, bundle)

    }


}