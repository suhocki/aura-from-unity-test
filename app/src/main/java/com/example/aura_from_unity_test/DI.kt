package com.example.aura_from_unity_test

import android.content.Context
import android.content.SharedPreferences
import com.example.aura_from_unity_test.storage.BootStorage
import com.example.aura_from_unity_test.storage.ConfigurationStorage

object DI {
    private const val PREFS_KEY = "PREFS_KEY"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
    }

    fun getBootStorage(context: Context): BootStorage {
        return BootStorage(getSharedPreferences(context))
    }

    fun getConfigurationStorage(context: Context): ConfigurationStorage {
        return ConfigurationStorage(getSharedPreferences(context))
    }
}