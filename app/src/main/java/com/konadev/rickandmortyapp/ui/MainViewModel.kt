package com.konadev.rickandmortyapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konadev.rickandmortyapp.models.CharactersResponse
import com.konadev.rickandmortyapp.repository.Repository
import com.konadev.rickandmortyapp.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val charactersData: MutableLiveData<Resource<CharactersResponse>> = MutableLiveData()

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() = viewModelScope.launch {
        charactersData.postValue(Resource.Loading())
        val response = repository.getCharacters()
        charactersData.postValue(handleCharactersResponse(response))
    }

    private fun handleCharactersResponse(response: Response<CharactersResponse>): Resource<CharactersResponse> {
        if(response.isSuccessful) {
            response.body()?.let { charactersResponse ->
                return Resource.Success(charactersResponse)
            }
        }
        return Resource.Failure(response.message())
    }
}