package com.example.your_beat_front.Service

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.your_beat_front.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {


    @SuppressLint("MissingPermission")
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        val notificationManager = NotificationManagerCompat.from(applicationContext)
        val builder: NotificationCompat.Builder

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
            builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
        } else {
            builder = NotificationCompat.Builder(applicationContext)
        }

        val title = remoteMessage.notification?.title
        val body = remoteMessage.notification?.body

        builder.setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.drawable.ic_bulb_42) // 적절한 아이콘으로 변경하세요.

        val notification = builder.build()
        notificationManager.notify(1, notification)
    }

    companion object {
        private const val CHANNEL_ID = "your_channel_id" // 적절한 채널 ID로 변경하세요.
        private const val CHANNEL_NAME = "Your Channel Name" // 적절한 채널 이름으로 변경하세요.
    }
}
