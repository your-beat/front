package com.example.your_beat_front.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.your_beat_front.DeviceDetailFragment
import com.example.your_beat_front.OperationFragment
import com.example.your_beat_front.data.Device

class DeviceTapAdapter(activity: FragmentActivity, private val device: Device) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DeviceDetailFragment.newInstance(device) // "세부정보" 탭에 해당하는 Fragment
            1 -> OperationFragment()                      // "조작" 탭에 해당하는 Fragment
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }

    override fun getItemCount(): Int {
        return 2 // 탭의 총 개수는 2개
    }
}
