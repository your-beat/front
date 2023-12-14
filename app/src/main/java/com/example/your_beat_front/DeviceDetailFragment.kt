package com.example.your_beat_front

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.your_beat_front.data.Device

class DeviceDetailFragment : Fragment() {
    private var device: Device? = null
    companion object {
        private const val ARG_DEVICE = "device"
        fun newInstance(device: Device): DeviceDetailFragment {
            val fragment = DeviceDetailFragment()
            val args = Bundle().apply {
                putSerializable(ARG_DEVICE, device)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            device = it.getSerializable(ARG_DEVICE) as Device
            Log.d("DeviceDetailFragment", "Device received: $device")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_device_detail, container, false)

        // 뷰에 Device 데이터 설정
        val deviceLocationTextView = view.findViewById<TextView>(R.id.device_location)
        val deviceStateTextView = view.findViewById<TextView>(R.id.device_state)

        deviceLocationTextView.text = device?.location ?: "위치 정보 없음"

        val deviceStatusText = when(device?.status) {
            0 -> "사용안함"
            1 -> "사용중"
            else -> "상태 정보 없음"
        }
        deviceStateTextView.text = deviceStatusText

        return view
    }
}
