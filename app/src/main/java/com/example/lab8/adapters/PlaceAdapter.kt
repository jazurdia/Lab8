package com.example.lab8.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout


class PlaceAdapter (
    val dataset: MutableList<Character> = mutableListOf(),
    val placeListener: characterListener

): RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){

    interface characterListener{
        fun onCharacterClick(character: Character)
    }

}

class ViewHolder(val view: View,
                 val listener: PlaceAdapter.characterListener): RecyclerView.ViewHolder(view){



}

