package com.example.aura_from_unity_test

import android.content.SharedPreferences
import androidx.core.content.edit

class Storage(
    private val sharedPreferences: SharedPreferences,
) {
    fun saveString(s: String) {
        sharedPreferences.edit {
            putStringSet(DATA, getStrings() + s)
        }
    }

    fun getStrings(): Set<String> {
        return sharedPreferences.getStringSet(DATA, emptySet())
            ?: emptySet() // getStringSet is nullable
    }

    companion object {
        private const val DATA = "DATA"
    }
}