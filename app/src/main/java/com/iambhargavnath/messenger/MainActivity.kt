package com.iambhargavnath.messenger

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iambhargavnath.messengerlibrary.adapter.MessageAdapter
import com.iambhargavnath.messengerlibrary.model.Message

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val messages = listOf(
            Message(sender = "other", content = "Hi", time = "2024-11-12 10:15:00", profilePicUrl = "https://masterpiecer-images.s3.yandex.net/a7a8505187f411eeb3fc5696910b1137:upscaled"),
            Message(sender = "me", content = "Hey! How's it going?", time = "2024-11-12 10:15:30"),
            Message(sender = "other", content = "Pretty good, thanks! Just finished work.", time = "2024-11-12 10:16:00", profilePicUrl = "https://masterpiecer-images.s3.yandex.net/a7a8505187f411eeb3fc5696910b1137:upscaled"),
            Message(sender = "other", content = "It was a long day, but I got a lot done.", time = "2024-11-12 10:16:15", profilePicUrl = "https://masterpiecer-images.s3.yandex.net/a7a8505187f411eeb3fc5696910b1137:upscaled"),
            Message(sender = "me", content = "Nice! Busy days can be satisfying.", time = "2024-11-12 10:16:30"),
            Message(sender = "me", content = "Are you free to catch up this weekend?", time = "2024-11-12 10:16:50"),
            Message(sender = "other", content = "Actually, I was just thinking about that!", time = "2024-11-12 10:17:00", profilePicUrl = "https://masterpiecer-images.s3.yandex.net/a7a8505187f411eeb3fc5696910b1137:upscaled"),
            Message(sender = "other", content = "Let's plan something fun.", time = "2024-11-12 10:17:20", profilePicUrl = "https://masterpiecer-images.s3.yandex.net/a7a8505187f411eeb3fc5696910b1137:upscaled"),
            Message(sender = "me", content = "Sounds good! How about Saturday afternoon?", time = "2024-11-12 10:17:40"),
            Message(sender = "other", content = "Perfect! Maybe we can grab some coffee?", time = "2024-11-12 10:18:00", profilePicUrl = "https://masterpiecer-images.s3.yandex.net/a7a8505187f411eeb3fc5696910b1137:upscaled"),
            Message(sender = "other", content = "There's a new café I wanted to try out.", time = "2024-11-12 10:18:15", profilePicUrl = "https://masterpiecer-images.s3.yandex.net/a7a8505187f411eeb3fc5696910b1137:upscaled"),
            Message(sender = "me", content = "Love it! It's been way too long since we caught up.", time = "2024-11-12 10:18:30"),
            Message(sender = "me", content = "Looking forward to hearing all your updates!", time = "2024-11-12 10:18:50"),
            Message(sender = "other", content = "Same here! Can't wait to see you.", time = "2024-11-12 10:19:00", profilePicUrl = "https://masterpiecer-images.s3.yandex.net/a7a8505187f411eeb3fc5696910b1137:upscaled"),
            Message(sender = "me", content = "Haha, there’s a lot to catch up on!", time = "2024-11-12 10:19:30"),
            Message(sender = "other", content = "See you Saturday!", time = "2024-11-12 10:20:00", profilePicUrl = "https://masterpiecer-images.s3.yandex.net/a7a8505187f411eeb3fc5696910b1137:upscaled")
        )

        val yourUserId = "me"
        val adapter = MessageAdapter(messageList = messages, yourUserId = yourUserId, onLongClick = {

        })
        recyclerView.adapter = adapter

        var shouldScrollToEnd = true
        val rootView = findViewById<View>(android.R.id.content)
        rootView.viewTreeObserver.addOnGlobalLayoutListener {
            val rect = Rect()
            rootView.getWindowVisibleDisplayFrame(rect)
            val screenHeight = rootView.rootView.height
            val keypadHeight = screenHeight - rect.bottom
            if (keypadHeight > screenHeight * 0.15) {
                if (shouldScrollToEnd) {
                    recyclerView.post {
                        recyclerView.scrollToPosition(adapter.itemCount - 1)
                    }
                    shouldScrollToEnd = false
                }
            } else {
                shouldScrollToEnd = true
            }
        }

    }
}