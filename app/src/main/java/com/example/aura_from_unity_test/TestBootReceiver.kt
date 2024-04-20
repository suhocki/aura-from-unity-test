package com.example.aura_from_unity_test

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import java.util.Date

class TestBootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val storage = DI.getStorage(context ?: return)
        val bootTime = System.currentTimeMillis() - SystemClock.elapsedRealtime()

        storage.saveBootDate(Date(bootTime))
    }

}