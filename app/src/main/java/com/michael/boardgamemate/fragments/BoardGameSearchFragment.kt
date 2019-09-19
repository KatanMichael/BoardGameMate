package com.michael.boardgamemate.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.michael.boardgamemate.R
import com.michael.boardgamemate.models.viewModels.BoardGamesViewModel

class BoardGameSearchFragment : Fragment() {

    companion object {
        fun newInstance() = BoardGameSearchFragment()
    }

    private lateinit var viewModel: BoardGamesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.board_game_search_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BoardGamesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
