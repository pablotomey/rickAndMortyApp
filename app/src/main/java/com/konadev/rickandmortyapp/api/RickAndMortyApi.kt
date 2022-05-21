package com.konadev.rickandmortyapp.api

import com.konadev.rickandmortyapp.models.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("api/character")
    suspend fun getCharacters(): Response<CharactersResponse>
}