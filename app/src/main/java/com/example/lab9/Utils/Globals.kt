package com.example.lab9.Utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
const val key_name = "azu21242@uvg.edu.gt"
const val preferences_name = "settings"

suspend fun DataStore<Preferences>.savePreferenceValue(key: String, value: String) {
    val key = stringPreferencesKey(key)
    edit { preferences ->
        preferences[key] = value
    }
}

suspend fun DataStore<Preferences>.getPreferenceValue(key: String): String? {
    val key = stringPreferencesKey(key)
    return data.first()[key]
}

suspend fun DataStore<Preferences>.clearPreferenceValue(key: String) {
    val key = stringPreferencesKey(key)
    edit { preferences ->
        preferences.remove(key)
    }
}

fun getEmail(): String {
    return key_name
}