package com.example.your_beat_front.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.your_beat_front.R
import com.example.your_beat_front.data.State

data class Device(val name: String, val state: String, val type: String, val location: String)
class MyDeviceListAdapter(private val devices: List<Device>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            State.ON -> {
                val binding = ItemDeviceOnCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DeviceOnViewHolder(binding)
            }
            State.OFF -> {
                val binding = ItemDeviceOffCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DeviceOffViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val device = devices[position]
        when (holder) {
            is DeviceOnViewHolder -> {
                // 'item_device_on_card.xml' 레이아웃에 데이터 바인딩
                holder.binding.apply {
                    // 예시: deviceName.text = device.name
                    // 데이터에 따라 필요한 뷰에 값을 설정
                }
            }
            is DeviceOffViewHolder -> {
                // 'item_device_off_card.xml' 레이아웃에 데이터 바인딩
                holder.binding.apply {
                    // 예시: deviceName.text = device.name
                    // 데이터에 따라 필요한 뷰에 값을 설정
                }
            }
        }
    }


    override fun getItemCount() = devices.size

    override fun getItemViewType(position: Int): Int {
        return if (devices[position].state == "on") State.ON else State.OFF
    }

    //todo : state에 따라 view 다르게 구성할 내용 작성.
    class DeviceOnViewHolder(val binding: ItemDeviceOnCardBinding): RecyclerView.ViewHolder(binding.root) { /* ... */ }
    class DeviceOffViewHolder(val binding: ItemDeviceOffCardBinding): RecyclerView.ViewHolder(binding.root) { /* ... */ }

}
