package io.dandi.android.ch03

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


class MyService : Service() {

    companion object {
        const val TAG = "MyService"
    }

    override fun onCreate() {

        super.onCreate()
        Log.d(TAG, "onCreate() 호출됨.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d(TAG, "onStartCommand() 호출됨.")

        if (intent == null) {
            return Service.START_STICKY
        } else {
            processCommand(intent)
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun processCommand(intent: Intent) {

        val command = intent.extras.getString("command")
        val name = intent.extras.getString("name")

        Log.d(TAG, "command : $command, name : $name")

        for (i in 0..4) {
            try {
                Thread.sleep(1000)
            } catch (e: Exception) {
            }

            Log.d(TAG, "Waiting $i seconds.")
        }

        val showIntent = Intent(applicationContext, SampleServiceActivity::class.java)
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        showIntent.putExtra("command", "show")
        showIntent.putExtra("name", "$name from service.")
        startActivity(showIntent)

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("MyService", "onDestroy() 호출됨.")
    }

    override fun onBind(intent: Intent): IBinder {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }


}
