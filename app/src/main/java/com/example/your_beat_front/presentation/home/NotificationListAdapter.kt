package com.example.your_beat_front.presentation.home

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.your_beat_front.R
import com.example.your_beat_front.data.Device
import com.example.your_beat_front.data.Notification
import com.example.your_beat_front.databinding.ItemNotificationCardBinding
import java.text.SimpleDateFormat
import java.util.Locale

class NotificationListAdapter(private val devices: List<Notification>) : RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder>() {

    class NotificationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // 뷰 바인딩 객체 사용 (레이아웃에 따라 이름이 달라질 수 있습니다)
        val binding = ItemNotificationCardBinding.bind(view)

        fun bind(notification: Notification) {
            binding.notificationName.text = notification.name

            val dateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.getDefault())
            val dateString = dateFormat.format(notification.time)
            binding.notificationTime.text = dateString
            binding.notificationInfo.text = notification.info


            // 기기 상태에 따라 배경 설정
//            val backgroundResId = if (notification.type==1){
//                R.drawable.card_gradient_gb_round
//            } else{
//                R.drawable.card_gradient_ro_round
//            }
//            binding.root.setBackgroundResource(backgroundResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notification_card, parent, false)
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeviceAdapter.DeviceViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

//    override fun onBindViewHolder(holder: DeviceAdapter.NotificationViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(dsevices[position])
    }

    override fun getItemCount(): Int {
        return devices.size
    }
}

class SpaceItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0) {
                top = space
            }
            left =  space
            right = space
            bottom = space
        }
    }
}

