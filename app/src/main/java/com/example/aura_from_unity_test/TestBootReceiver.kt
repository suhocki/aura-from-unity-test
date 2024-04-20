package com.example.aura_from_unity_test

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.SystemClock

class TestBootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val storage = DI.getStorage(context ?: return)
        val bootTime = System.currentTimeMillis() - SystemClock.elapsedRealtime()

        storage.saveString(bootTime.toString())
    }

}