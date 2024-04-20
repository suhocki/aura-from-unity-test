package com.example.aura_from_unity_test

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

object Mappers {
    object DateToFormattedString{
        @SuppressLint("SimpleDateFormat")
        private val dateFormatter = SimpleDateFormat("dd/MM/yyyy")
        fun map(date: Date): String {
            return dateFormatter.format(date)
        }
    }
}