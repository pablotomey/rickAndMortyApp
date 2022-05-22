package com.konadev.rickandmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.konadev.rickandmortyapp.repository.Repository
import com.konadev.rickandmortyapp.ui.MainViewModel
import com.konadev.rickandmortyapp.ui.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(Repository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.mainNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}