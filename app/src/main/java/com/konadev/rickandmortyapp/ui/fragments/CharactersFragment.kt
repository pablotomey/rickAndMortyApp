package com.konadev.rickandmortyapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.konadev.rickandmortyapp.MainActivity
import com.konadev.rickandmortyapp.R
import com.konadev.rickandmortyapp.models.Character
import com.konadev.rickandmortyapp.ui.MainViewModel
import com.konadev.rickandmortyapp.ui.adapters.CharactersAdapter
import com.konadev.rickandmortyapp.utils.Resource
import kotlinx.android.synthetic.main.fragment_characters.*

class CharactersFragment: Fragment(R.layout.fragment_characters), CharactersAdapter.OnCharacterClickListener {

    private lateinit var mainViewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        mainViewModel = (activity as MainActivity).viewModel

        mainViewModel.charactersData.observe(viewLifecycleOwner) { response ->
            when(response) {
                is Resource.Loading -> showProgressBar()
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { charactersResponse ->  
                        characters_rv.adapter = CharactersAdapter(requireContext(), charactersResponse.results, this )
                    }
                }
                is Resource.Failure -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e("Error:", message)
                    }
                }
            }
        }
    }

    private fun setupRecyclerView() {
        characters_rv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
        }
    }

    private fun showProgressBar() {
        characters_progress_bar.isVisible = true
    }

    private fun hideProgressBar() {
        characters_progress_bar.isVisible = false
    }

    override fun onCharacterClick(character: Character, position: Int) {
        Toast.makeText(requireContext(), "Click item!", Toast.LENGTH_SHORT).show()
    }
}