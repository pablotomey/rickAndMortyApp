package com.konadev.rickandmortyapp.models

data class CharactersResponse(
    val info: Info,
    val results: List<Character>
)