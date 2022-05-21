package com.konadev.rickandmortyapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.konadev.rickandmortyapp.R
import com.konadev.rickandmortyapp.base.BaseViewHolder
import com.konadev.rickandmortyapp.models.Character
import kotlinx.android.synthetic.main.character_item_row.view.*

class CharactersAdapter(
    private val context: Context,
    private val characters: List<Character>,
    private val itemClickListener: OnCharacterClickListener
): RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnCharacterClickListener {
        fun onCharacterClick(character: Character, position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return CharacterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.character_item_row, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder) {
            is CharacterViewHolder -> holder.bind(characters[position], position)
        }
    }

    override fun getItemCount(): Int = characters.size

    inner class CharacterViewHolder(itemView: View): BaseViewHolder<Character>(itemView) {
        override fun bind(item: Character, position: Int) {
            Glide.with(context).load(item.image).centerCrop().into(itemView.image)
            itemView.name.text = item.name

            itemView.setOnClickListener { itemClickListener.onCharacterClick(item, position) }
        }

    }
}