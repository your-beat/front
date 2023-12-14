package com.example.your_beat_front

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.your_beat_front.data.Device
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
        val deviceState = findViewById<TextView>(R.id.tag_device_state)

        // 데이터 설정
        //device = getDeviceData() // 기기 데이터 가져오기
        device = intent.getSerializableExtra("device") as Device
        Log.d("DeviceDetailActivity", "Device received: $device")
        // 아이콘 설정
        val iconResId = when (device.type) {
            // 기기 타입에 따른 아이콘 설정
            0 -> R.drawable.ic_station_42//station 아이콘
            1 -> R.drawable.ic_tv_42   // TV 아이콘
            2 -> R.drawable.ic_bulb_42//조명 아이콘
            // 다른 기기 종류에 따른 아이콘 추가
            else -> R.drawable.ic_default_42 // 기본 아이콘
        }
        val drawable = ContextCompat.getDrawable(this, iconResId)?.mutate()
        drawable?.let {
            DrawableCompat.setTint(it, ContextCompat.getColor(this, R.color.main))
            deviceIcon.setImageDrawable(it)
        }
        val deviceStatusTextView = findViewById<TextView>(R.id.tag_device_state)

        val (backgroundResId, textResId,textColorResId) = when(device.status) {
            0 -> Triple(R.drawable.tag_inactive, R.string.text_inactive,R.color.sub300) // "사용안함" 상태
            1 -> Triple(R.drawable.tag_active, R.string.text_active,R.color.main)     // "사용중" 상태
            else -> Triple(R.drawable.tag_inactive, R.string.text_inactive,R.color.sub300) // 기본값
        }

        val btnPrevious = findViewById<ImageButton>(R.id.btn_previous)
        btnPrevious.setOnClickListener {
            finish() // 현재 액티비티 종료
        }

        // 기기 이름과 제품코드 설정
        deviceName.text = device.name
        deviceCode.text = device.code
        deviceStatusTextView.setBackgroundResource(backgroundResId)
        deviceStatusTextView.setText(textResId)
        deviceStatusTextView.setTextColor(ContextCompat.getColor(this, textColorResId))
    }

    private fun setupTabLayoutAndViewPager() {
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)

        val adapter = DeviceTapAdapter(this,device)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = if (position == 0) "세부정보" else "조작"
        }.attach()
    }


    private fun getDeviceData(): Device {
        // 기기 데이터 로드 및 반환
        // 예시 데이터 반환
        return Device("기기이름", 0,1 ,"위치","제품코드") // 여기에 실제 데이터 로딩 로직 추가
    }
}
