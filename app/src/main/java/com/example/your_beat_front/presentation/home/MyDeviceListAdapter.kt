package com.example.your_beat_front.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.your_beat_front.R
import com.example.your_beat_front.data.Device
import com.example.your_beat_front.databinding.ItemDeviceCardBinding

class DeviceAdapter(private val devices: List<Device>) : RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder>() {

    class DeviceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // 뷰 바인딩 객체 사용 (레이아웃에 따라 이름이 달라질 수 있습니다)
        val binding = ItemDeviceCardBinding.bind(view)

        fun bind(device: Device) {
            binding.deviceName.text = device.name
            binding.deviceLocation.text = device.location
            binding.deviceStatus.text = if (device.status == 0) "off" else "on"

            // 기기 종류에 따라 아이콘 설정 (예제입니다, 실제 코드는 다를 수 있음)
            val iconResId = when (device.type) {
                0 -> R.drawable.ic_station_42//station 아이콘
                1 -> R.drawable.ic_tv_42   // TV 아이콘
                2 -> R.drawable.ic_bulb_42//조명 아이콘
                // 다른 기기 종류에 따른 아이콘 추가
                else -> R.drawable.ic_default_42 // 기본 아이콘
            }
            binding.deviceIcon.setImageResource(iconResId)

            // 기기 상태에 따라 배경 설정
            val backgroundResId = if (device.status == 1) R.drawable.card_gradient_gb_round else R.drawable.card_gradient_ro_round
            binding.root.setBackgroundResource(backgroundResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_device_card, parent, false)
        return DeviceViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        holder.bind(devices[position])
    }

    override fun getItemCount(): Int {
        return devices.size
    }
}

