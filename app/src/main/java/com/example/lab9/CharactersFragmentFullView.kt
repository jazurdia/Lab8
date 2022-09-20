package com.example.lab9

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.example.lab9.R
import com.example.lab9.adapters.PlaceAdapter


class CharactersFragmentFullView : Fragment(R.layout.fragment_character_fullview){

    private lateinit var image : ImageView
    private lateinit var name : TextView
    private lateinit var status: TextView
    private lateinit var species: TextView
    private lateinit var gender: TextView
    private val args: CharactersFragmentFullViewArgs by navArgs()




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.image_of_character)
        name = view.findViewById(R.id.name_of_character)
        status = view.findViewById(R.id.status_of_character)
        species = view.findViewById(R.id.species_of_character)
        gender = view.findViewById(R.id.gender_of_character)
        getCharactesrDetails()
    }

        @SuppressLint("SetTextI18n")
    private fun getCharactesrDetails() {
        getImage(args.image)
        name.text = "Nombre: " + args.name
        status.text = "Estado: " + args.status
        species.text = "Especie: " + args.specie
        gender.text = "Genero: " + args.gender
    }

    private fun getImage(imageUrl: String) {
        image.load(imageUrl){
            transformations(CircleCropTransformation())
            error(R.drawable.ic_baseline_error_outline_24)
            diskCachePolicy(CachePolicy.ENABLED)
            memoryCachePolicy(CachePolicy.ENABLED)
        }
    }



}