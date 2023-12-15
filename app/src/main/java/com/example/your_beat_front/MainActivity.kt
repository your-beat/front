package com.example.your_beat_front

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.your_beat_front.databinding.ActivityMainBinding
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
        requestFCMToken();
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = binding.bnvHome

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> replaceFragment(HomeFragment())
                //todo : 하단 네비에서 마이페이지, 알림 리스트 구현
                R.id.menu_notification -> replaceFragment(NotificationFragment())
                //R.id.menu_my_page -> replaceFragment(MyPageFragment())
                else -> false
            }
            true
        }
        // Set initial fragment
        bottomNavigationView.selectedItemId = R.id.menu_home
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fcv_home_container, fragment)
            commit()
        }
    }

    private fun requestFCMToken(){
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("MainActivity", "Fetching FCM token failed", task.exception)
                return@addOnCompleteListener
            }

            // 토큰 받아오기 성공
            val token = task.result
            // 토큰을 로그로 출력하거나 서버에 전송하는 등의 작업 수행
            Log.d("MainActivity", "FCM Token: $token")
        }
    }
}
