    package com.example.your_beat_front

    import android.content.Intent
    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.constraintlayout.widget.ConstraintLayout
    import androidx.fragment.app.Fragment
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.example.your_beat_front.Service.ApiService
    import com.example.your_beat_front.Service.RetrofitClient
    import com.example.your_beat_front.data.DataManager
    import com.example.your_beat_front.data.Device
    import com.example.your_beat_front.data.DeviceDataSource
    import com.example.your_beat_front.databinding.FragmentHomeBinding
    import com.example.your_beat_front.presentation.home.DeviceAdapter
    import com.example.your_beat_front.presentation.home.SpaceItemDecoration


    class HomeFragment : Fragment(),DeviceAdapter.OnDeviceClickListener {

        private lateinit var dataManager: DataManager
        private var _binding: FragmentHomeBinding? = null
        private val binding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = FragmentHomeBinding.inflate(inflater, container, false)
            val view = binding.root

            // modeBox 레이아웃을 찾아서 visibility 설정
            val modeBox = view.findViewById<View>(R.id.mode_box)
            modeBox.visibility = View.GONE

            // item_add_device 레이아웃에 대한 참조를 가져옵니다.
            val addDeviceLayout = view.findViewById<ConstraintLayout>(R.id.btn_add_device)

            // 클릭 이벤트 리스너를 추가합니다.
            addDeviceLayout.setOnClickListener {
                refreshDeviceList()
            }


            // RecyclerView 설정
            setupRecyclerView()


            return view
        }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val apiService = RetrofitClient.retrofitInstance.create(ApiService::class.java)
            dataManager = DataManager(apiService)
        }
        private fun setupRecyclerView() {
            val devices = DeviceDataSource.getDummyDevices() // 더미 데이터 가져오기
            val adapter = DeviceAdapter(devices, this) // 여기서 this는 OnDeviceClickListener 구현체
            with(binding.deviceListRecyclerView) {
                layoutManager = LinearLayoutManager(context) // 리사이클러뷰에 레이아웃 매니저 설정
                this.adapter = adapter // 리사이클러뷰에 어댑터 설정
                addItemDecoration(SpaceItemDecoration(20)) // 10px의 간격을 추가합니다.
            }

        }
        private fun fetchDeviceData() {
            dataManager.fetchDevices { devices, error ->
                error?.let {
                    // 오류 처리
                } ?: run {
                    devices?.let {
                        //TODO : data/Device 에 맞춰서 넣는 과정 or Device 구조 변경
                        // 디바이스 데이터 처리, UI 업데이트 등
                        updateUI(it)
                    }
                }
            }
        }

        // 디바이스 데이터를 사용하여 UI 업데이트
        private fun updateUI(devices: List<Device>) {
            val adapter = DeviceAdapter(devices, this)
            binding.deviceListRecyclerView.adapter = adapter
        }
        private fun refreshDeviceList() {
            //새로고침 요청
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

        override fun onDeviceClick(device: Device) {
            val intent = Intent(context, DeviceDetailActivity::class.java).apply {
                putExtra("device", device) // 전체 Device 객체 전달
            }
            startActivity(intent)
        }
    }
