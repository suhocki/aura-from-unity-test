package com.example.aura_from_unity_test.storage

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.aura_from_unity_test.NotificationConstants
import kotlin.math.max

class ConfigurationStorage(
    private val sharedPreferences: SharedPreferences,
) {
    var dismissalCount: Int
        get() {
            return sharedPreferences.getInt(DISMISSAL_COUNT, 0)
        }
        set(value) {
            sharedPreferences.edit {
                putInt(DISMISSAL_COUNT, value)
            }
        }

    var notificationDismissLimit: Int
        get() {
            return sharedPreferences.getInt(
                DISMISS_LIMIT_KEY,
                NotificationConstants.DEFAULT_DISMISS_LIMIT
            )
        }
        set(value) {
            sharedPreferences.edit {
                putInt(DISMISS_LIMIT_KEY, value)
            }
        }

    var notificationInterval: Int
        get() {
            return sharedPreferences.getInt(INTERVAL_KEY, 0)
        }
        set(value) {
            sharedPreferences.edit {
                putInt(INTERVAL_KEY, max(0, value))
            }
        }

    companion object {
        private const val DISMISS_LIMIT_KEY = "NOTIFICATION_DISMISS_LIMIT"
        private const val INTERVAL_KEY = "NOTIFICATION_INTERVAL"
        private const val DISMISSAL_COUNT = "DISMISSAL_COUNT"
    }
}