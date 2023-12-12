import com.example.your_beat_front.data.Notification
import java.time.LocalDateTime

object NoticeDataSource{
    fun getDummyNotice(): List<Notification>{
        return listOf(
            Notification("조명", LocalDateTime.of(2023,12,11,10,15), "조명을 켰습니다.",0),
            Notification("조명", LocalDateTime.of(2023,12,11,10,35), "조명을 껐습니다.",0),
            Notification("TV", LocalDateTime.of(2023,12,11,10,45), "TV를 켰습니다.",0),
            Notification("이상감지", LocalDateTime.of(2023,12,11,13,10), "일정시간 움직임이 감지 되지 않았습니다.",1)
        )
    }
}