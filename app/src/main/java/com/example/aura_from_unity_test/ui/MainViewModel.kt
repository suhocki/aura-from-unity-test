package com.example.aura_from_unity_test.ui

import androidx.lifecycle.ViewModel
import com.example.aura_from_unity_test.Mappers
import com.example.aura_from_unity_test.NotificationConstants
import com.example.aura_from_unity_test.storage.BootStorage
import com.example.aura_from_unity_test.storage.ConfigurationStorage

class MainViewModel(
    private val configurationStorage: ConfigurationStorage,
    private val bootStorage: BootStorage,
    private val dateToFormattedStringMapper: Mappers.DateToFormattedString = Mappers.DateToFormattedString,
) : ViewModel() {
    fun getBootDates(): String {
        return bootStorage.getBootDates()
            .groupBy(dateToFormattedStringMapper::map)
            .map { (dateFormatted, events) -> "$dateFormatted - ${events.size}" }
            .joinToString(separator = "\n")
    }

    fun changeNotificationDismissLimit(limit: Int?) {
        configurationStorage.notificationDismissLimit = limit ?: NotificationConstants.DEFAULT_DISMISS_LIMIT
    }

    fun changeNotificationInterval(interval: Int?) {
        configurationStorage.notificationInterval = interval ?: calculateDefaultInterval()
    }

    private fun calculateDefaultInterval(): Int {
        return configurationStorage.dismissalCount * NotificationConstants.INTERVAL_PER_DISMISSAL
    }
}