package com.konadev.rickandmortyapp.repository

import com.konadev.rickandmortyapp.api.RetrofitClient

class Repository {
    suspend fun getCharacters() = RetrofitClient.rickAndMortyApi.getCharacters()
}