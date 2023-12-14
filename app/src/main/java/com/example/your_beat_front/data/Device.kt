package com.example.your_beat_front.data

import java.io.Serializable

data class Device(
    val name: String,       // 기기명
    val type: Int,          // 기기종류 고유 코드
    val status: Int,        // 기기 상태 (예: 0 = off, 1 = on) ,object State 참조
    val location: String,   // 위치
    val code:String         // 제품코드
): Serializable
