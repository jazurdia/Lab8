package com.example.lab9.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.lab9.R
import com.example.lab9.database.Character


class PlaceAdapter (private val dataset: MutableList<Character>, private val listener: RecyclerViewCharacter) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_place, parent, false) // revisar item_recycler_place
        return ViewHolder(view, listener)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.set_data(dataset[position])
    }




    class ViewHolder(view: View, private val listener: RecyclerViewCharacter) : RecyclerView.ViewHolder(view) {

        private val image: ImageView = view.findViewById(R.id.item_image_character)
        private val name: TextView = view.findViewById(R.id.item_name)
        private val status: TextView = view.findViewById(R.id.item_status)
        private val species: TextView = view.findViewById(R.id.item_species)
        private val lay_char: ConstraintLayout = view.findViewById(R.id.item_recycler_place) // item_recycler_place

        fun set_data(character: Character) {

            name.text = character.name
            status.text = character.status
            species.text = character.species
            get_image(character.image)

            lay_char.setOnClickListener {
                listener.onCharacterClick(character)
            }
        }

        fun get_image(url: String) { // pedir ayuda.
            image.load(url) {
                transformations(CircleCropTransformation())
                error(R.drawable.ic_baseline_error_outline_24)
                diskCachePolicy(CachePolicy.ENABLED)
                memoryCachePolicy(CachePolicy.ENABLED)
            }
        }
    }

    interface RecyclerViewCharacter {
        fun onCharacterClick(character: Character)
    }

    override fun getItemCount() = dataset.size

}