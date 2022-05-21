package com.konadev.rickandmortyapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.konadev.rickandmortyapp.repository.Repository

class MainViewModelFactory(val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repository::class.java).newInstance(repository)
    }
}