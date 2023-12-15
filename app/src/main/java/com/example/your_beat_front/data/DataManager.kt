package com.example.your_beat_front.data

import com.example.your_beat_front.Service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class DataManager(private val apiService: ApiService) {

    fun fetchDevices(callback: (List<Device>?, Throwable?) -> Unit) {
        apiService.getDevices().enqueue(object : Callback<List<Device>> {
            override fun onResponse(call: Call<List<Device>>, response: Response<List<Device>>) {
                if (response.isSuccessful) {
                    callback(response.body(), null)
                } else {
                    callback(null, RuntimeException("Response not successful"))
                }
            }

            override fun onFailure(call: Call<List<Device>>, t: Throwable) {
                callback(null, t)
            }
        })
    }
    fun fetchDeviceDetails(deviceId: String, callback: (Device?, Throwable?) -> Unit) {
        apiService.getDeviceDetails(deviceId).enqueue(object : Callback<Device> {
            override fun onResponse(call: Call<Device>, response: Response<Device>) {
                if (response.isSuccessful) {
                    callback(response.body(), null)
                } else {
                    callback(null, RuntimeException("Response not successful"))
                }
            }

            override fun onFailure(call: Call<Device>, t: Throwable) {
                callback(null, t)
            }
        })
    }
}
