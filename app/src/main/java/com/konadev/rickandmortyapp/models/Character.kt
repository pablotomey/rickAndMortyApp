package com.konadev.rickandmortyapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class Character(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
): Serializable