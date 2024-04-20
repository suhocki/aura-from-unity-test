package com.example.aura_from_unity_test

import android.content.SharedPreferences
import androidx.core.content.edit
import java.util.Date

class BootStorage(
    private val sharedPreferences: SharedPreferences,
) {
    fun saveBootDate(date: Date) {
        val epochTimes = (getBootDates() + date).map(Date::getTime)

        sharedPreferences.edit {
            putStringSet(BOOT_TIMESTAMPS, epochTimes.map(Long::toString).toSet())
        }
    }

    fun getBootDates(): List<Date> {
        val epochTimes = sharedPreferences.getStringSet(BOOT_TIMESTAMPS, emptySet())
            .orEmpty()
            .map(String::toLong)

        return epochTimes.map(::Date)
    }

    companion object {
        private const val BOOT_TIMESTAMPS = "BOOT_TIMESTAMPS"
    }
}