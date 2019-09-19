package com.michael.boardgamemate.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.michael.boardgamemate.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        

        navController = this.findNavController(R.id.nav_host_fragment)


        bottom_navigation.setOnNavigationItemSelectedListener(fun(it: MenuItem) : Boolean
        {
            when(it.itemId)
            {
                R.id.gamesList ->
                {
                    navController.navigate(R.id.boardGameSearchFragment)

                }
                R.id.newsFeed ->
                {
                    navController.navigate(R.id.newsFragment)

                }

            }


            return true
        })

    }
}
