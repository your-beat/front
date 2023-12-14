package com.example.your_beat_front.data

object DeviceDataSource {

    fun getDummyDevices(): List<Device> {
        return listOf(
            Device("SmartThings Station", 0, 1, "방1","a123456789"),
            Device("TV", 1, 1, "거실","b123456789"),
            Device("조명", 2, 0, "방1","c123456789"),
            Device("에어컨", 3, 0, "거실","d123456789"),
            Device("냉장고", 4, 0, "주방","e123456789"),
            Device("세탁기", 5, 1, "다용도실","f123456789"),
            Device("오븐", 6, 1, "주방","g123456789"),
            Device("조명", 2, 0, "화장실","h123456789"),
            Device("SmartThings Station", 0, 1, "거실","i123456789")
        )
    }
}
