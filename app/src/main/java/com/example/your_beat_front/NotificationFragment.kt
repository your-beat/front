
package com.example.your_beat_front

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.your_beat_front.data.DeviceDataSource
import com.example.your_beat_front.databinding.FragmentHomeBinding
import com.example.your_beat_front.databinding.FragmentNotificationBinding
import com.example.your_beat_front.presentation.home.DeviceAdapter
import com.example.your_beat_front.presentation.home.SpaceItemDecoration

class NotificationFragment : Fragment() {

    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        val view = binding.root

        // RecyclerView 설정
        setupRecyclerView()

        return view
    }

    private fun setupRecyclerView() {
        val devices = DeviceDataSource.getDummyDevices() // 더미 데이터 가져오기
        val adapter = DeviceAdapter(devices)

        with(binding.deviceListRecyclerView) {
            layoutManager = LinearLayoutManager(context) // 리사이클러뷰에 레이아웃 매니저 설정
            this.adapter = adapter // 리사이클러뷰에 어댑터 설정
            addItemDecoration(SpaceItemDecoration(20)) // 10px의 간격을 추가합니다.
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
