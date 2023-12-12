package com.example.your_beat_front.data

import java.sql.Date
import java.time.LocalDateTime

data class Notification(
    val name: String,    // 기기명
    val dateTime: LocalDateTime,       // 로그 시간
    val info: String,    // 로그 내용
    val type: Int       // 알림 종류
)
