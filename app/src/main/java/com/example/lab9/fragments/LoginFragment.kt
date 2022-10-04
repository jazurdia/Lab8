package com.example.lab9.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.navigation.findNavController
import com.example.lab9.R
import com.example.lab9.Utils.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var botonIniciarSesion : Button
    private lateinit var correo: TextInputLayout
    private lateinit var contrasena: TextInputLayout

    private lateinit var logged: String

    override fun onViewCreated (view:View, savedInstanceState:Bundle ?) {
        super.onViewCreated(view, savedInstanceState)
        apply {
            correo = view.findViewById(R.id.correoInput)
            contrasena = view.findViewById(R.id.contrasenaInput)
            botonIniciarSesion = view.findViewById(R.id.boton_iniciar_sesion)
            isloged()
            setListeners()

        }
    }

    private fun isloged(){
        CoroutineScope(Dispatchers.IO).launch {
            val currentUser = requireContext().dataStore.getPreferenceValue(key_name)
            if(currentUser != null){
                navigateToHome()
            }
        }
    }

    private fun navigateToHome(){
        CoroutineScope(Dispatchers.IO).launch {
        requireView().findNavController().navigate(R.id.action_login_to_character_Details_Fragment)

        }
    }


    private fun setListeners(){
        botonIniciarSesion.setOnClickListener {
            logIn(
                email = correo.editText!!.text.toString(),
                password = contrasena.editText!!.text.toString()
            )
        }
    }

    private fun logIn(email: String, password: String) {
        if (email == getString(R.string.correo_personal) && password == getString(R.string.correo_personal)) {
            saveUser(email)
            //navigateToHome()
        } else {
            Toast.makeText(requireContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveUser(email: String) {
        CoroutineScope(Dispatchers.IO).launch {
            requireContext().dataStore.savePreferenceValue(key_name, email)
            //navigateToHome()

        }

        requireView().findNavController().navigate(R.id.action_login_to_character_Details_Fragment)

    }

}