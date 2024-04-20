package com.example.aura_from_unity_test

import androidx.lifecycle.ViewModel
import com.example.aura_from_unity_test.storage.ConfigurationStorage

class MainViewModel(
    private val configurationStorage: ConfigurationStorage
) : ViewModel() {
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