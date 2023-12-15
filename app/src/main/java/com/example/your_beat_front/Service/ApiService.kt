package com.example.your_beat_front.Service

import android.util.Log
import com.example.your_beat_front.data.Device
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body

interface ApiService {
    @GET("/devices")
    fun getDevices(): Call<List<Device>>

    @POST("/fcm")
    fun saveFcmToken(@Body fcmToken: FcmToken): Call<Void>

    @GET("/logs")
    fun getLogs(): Call<List<Log>>
}

data class FcmToken(val token: String)
