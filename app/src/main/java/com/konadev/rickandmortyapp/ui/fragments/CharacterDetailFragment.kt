package com.konadev.rickandmortyapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.konadev.rickandmortyapp.R
import kotlinx.android.synthetic.main.fragment_character_detail.*

class CharacterDetailFragment: Fragment(R.layout.fragment_character_detail) {

    val args: CharacterDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = args.character
        Glide.with(this).load(character.image).centerCrop().into(character_img)
        character_name.text = getString(R.string.character_name, character.name)
        character_status.text = getString(R.string.character_status, character.status)
        character_species.text = getString(R.string.character_species, character.species)
        character_gender.text = getString(R.string.character_gender, character.gender)
    }
}