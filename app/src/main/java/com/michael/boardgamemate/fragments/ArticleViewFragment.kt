package com.michael.boardgamemate.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.michael.boardgamemate.R
import com.prof.rssparser.Article
import kotlinx.android.synthetic.main.fragment_article_view.*

class ArticleViewFragment : Fragment()
{
    var articleTitle: String = ""
    var articleContent : String = ""



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        articleTitle = arguments!!.getString("title")
        articleContent = arguments!!.getString("content")


        return inflater.inflate(R.layout.fragment_article_view, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        articleViewAuthor.setText(articleTitle)
        articleWebView.loadData(articleContent,"text/html", "UTF-8")

    }



}
