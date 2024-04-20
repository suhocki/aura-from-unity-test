package com.example.aura_from_unity_test

import android.content.Context

object DI {
    private const val PREFS_KEY = "PREFS_KEY"

    fun getStorage(context: Context): Storage {
        val prefs = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        return Storage(sharedPreferences = prefs)
    }
}