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
import java.time.format.DateTimeFormatter
import java.util.Locale

class NotificationListAdapter(private val notice: List<Notification>) : RecyclerView.Adapter<NotificationListAdapter.NotificationViewHolder>() {

    class NotificationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // 뷰 바인딩 객체 사용 (레이아웃에 따라 이름이 달라질 수 있습니다)
        val binding = ItemNotificationCardBinding.bind(view)

        fun bind(notification: Notification) {
            binding.notificationName.text = notification.name

            val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")
            val formattedDateTime = notification.dateTime.format(formatter)
            binding.notificationTime.text = formattedDateTime
            binding.notificationInfo.text = notification.info

            // type가 1일 경우(이상 감지 알림의 경우) 글자색 및 배경 변경
            if (notification.type == 1) {
                val whiteColor = ContextCompat.getColor(itemView.context, android.R.color.white)
                binding.notificationName.setTextColor(whiteColor)
                binding.notificationTime.setTextColor(whiteColor)
                binding.notificationInfo.setTextColor(whiteColor)
                binding.root.setBackgroundResource(R.drawable.card_gradient_gb_round)
            } else {
                // 기본 색상 및 배경 설정
                val blackColor = ContextCompat.getColor(itemView.context, R.color.text_black)
                val grayColor = ContextCompat.getColor(itemView.context, R.color.text_gray)
                val mainColor = ContextCompat.getColor(itemView.context, R.color.main)
                binding.notificationName.setTextColor(blackColor)
                binding.notificationTime.setTextColor(mainColor)
                binding.notificationInfo.setTextColor(grayColor)
                binding.root.setBackgroundResource(R.drawable.card_white_round)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notification_card, parent, false)
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationListAdapter.NotificationViewHolder, position: Int) {
        holder.bind(notice[position])
    }

    override fun getItemCount(): Int {
        return notice.size
    }
}

