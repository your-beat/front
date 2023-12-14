package com.example.your_beat_front

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class DeviceDetailFragment : Fragment() {
    private var tabIndex: Int = 0

    companion object {
        private const val ARG_TAB_INDEX = "tab_index"

        fun newInstance(tabIndex: Int): DeviceDetailFragment {
            val fragment = DeviceDetailFragment()
            val args = Bundle()
            args.putInt(ARG_TAB_INDEX, tabIndex)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tabIndex = it.getInt(ARG_TAB_INDEX)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_device_detail, container, false)
        // 여기에 탭 별 UI 구성 코드를 작성하세요
        return view
    }
}
