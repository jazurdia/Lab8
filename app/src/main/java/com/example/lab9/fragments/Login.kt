package com.example.lab9.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.lab9.R

class Login : Fragment(R.layout.fragment_login) {

    private lateinit var correo : EditText
    private lateinit var contrasena : EditText
    private lateinit var botonIniciarSesion : Button

    override fun onViewCreated(view:View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        correo = view.findViewById(R.id.correoInput)
        contrasena = view.findViewById(R.id.contrasenaInput)
        setListener()

    }

    private fun sonIguales (mycorreo: EditText, mycontrasena: EditText): Boolean {
        val comprobador = getString(R.string.correo_personal)
        return mycorreo.text.toString() == comprobador && mycontrasena.text.toString() == comprobador
    }

    private fun setListener(){
        botonIniciarSesion.setOnClickListener{
            if (sonIguales(correo, contrasena)){
                it.findNavController().navigate(R.id.action_login_to_character_Details_Fragment)
            } else {
                val message = "Correo o contraseña incorrectos"
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        }
    }






}