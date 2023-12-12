package com.example.your_beat_front

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.your_beat_front.presentation.home.DeviceTapAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DeviceDetailActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    // 예시 데이터
    private lateinit var device: Device

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_detail)

        setupViews()
        setupTabLayoutAndViewPager()
    }

    private fun setupViews() {
        // 뷰 참조 가져오기
        val deviceIcon = findViewById<ImageView>(R.id.device_icon)
        val deviceName = findViewById<TextView>(R.id.txt_device_name)
        val deviceCode = findViewById<TextView>(R.id.txt_device_code)

        // 데이터 설정
        device = getDeviceData() // 기기 데이터 가져오기

        // 아이콘 설정
        val iconResId = when (device.type) {
            // 기기 타입에 따른 아이콘 설정
            // 예: 1 -> R.drawable.ic_device_type1
            else -> R.drawable.ic_launcher_background // 기본 아이콘
        }
        deviceIcon.setImageResource(iconResId)

        // 기기 이름과 제품코드 설정
        deviceName.text = device.name
        deviceCode.text = device.code
    }

    private fun setupTabLayoutAndViewPager() {
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)

        // TabLayout과 ViewPager2 연결 및 설정
        val adapter = DeviceTapAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // 탭 제목 설정
            tab.text = "Tab ${position + 1}"
        }.attach()
    }

    private fun getDeviceData(): Device {
        // 기기 데이터 로드 및 반환
        // 예시 데이터 반환
        return Device("기기이름", "제품코드", 1) // 여기에 실제 데이터 로딩 로직 추가
    }
}

data class Device(val name: String, val code: String, val type: Int) // 기기 데이터 클래스
