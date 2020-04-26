package com.codegemz.kotlinx.lesson4

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.setContentView
import android.app.AlarmManager
import android.app.PendingIntent

class MainActivity : AppCompatActivity() {
    private lateinit var view: MainView

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            if (service is MyService.LocalBinder) {
                service.onPlayingStarted = {
                    view.updatePlayButton(true)
                }
                service.onPlayingStopped = {
                    view.updatePlayButton(false)
                }
            }
            view.updatePlayButton(false)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = MainView()
        view.setContentView(this)

        // Bind service for receiving callbacks
        val intent = Intent(this, MyService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Stop when the app is closed
        MyService.stopService(this)
        unbindService(serviceConnection)
    }

    fun setAlarm(alarmTime: Long) {
        // setup alarm
        val alarmManager = getSystemService (Context.ALARM_SERVICE) as AlarmManager
        val intent = MyService.getPlayIntent (this)
        val pendingIntent = PendingIntent.getService (this, 1, intent, 0)
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent)
    }
}
