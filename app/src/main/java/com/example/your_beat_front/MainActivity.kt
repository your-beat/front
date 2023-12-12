package com.example.your_beat_front

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.your_beat_front.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
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
}
