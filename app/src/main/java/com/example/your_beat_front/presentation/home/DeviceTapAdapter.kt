package com.example.your_beat_front.presentation.home

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DeviceTapAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DeviceDetailFragment()  // "세부 정보" 탭에 해당하는 프래그먼트
            //1 -> DeviceControlFragment() // "기기 조작" 탭에 해당하는 프래그먼트
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}
