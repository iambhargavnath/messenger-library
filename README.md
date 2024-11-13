# Messenger Library
This is a simple to implement Android Messenger UI.

## Screenshots
<p>
<img align="center" src="https://github.com/iambhargavnath/messenger-library/blob/master/Screenshot1.png" alt="Screenshot1" width="360"/>
<img align="center" src="https://github.com/iambhargavnath/messenger-library/blob/master/Screenshot2.png" alt="Screenshot2" width="360"/>
</p>
<p>
<img align="center" src="https://github.com/iambhargavnath/messenger-library/blob/master/Screenshot3.png" alt="Screenshot3" width="360"/>
<img align="center" src="https://github.com/iambhargavnath/messenger-library/blob/master/Screenshot4.png" alt="Screenshot4" width="360"/>
</p>

## Installation

### Installation for Groovy DSL

1. Add the following dependency in your project's `build.gradle` file:
```
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
  }
}
```

2. Add the following dependency in your app's `build.gradle` file:
```
dependencies {
  implementation 'com.github.iambhargavnath:messenger-library:v1.0.0'
}
```

### Installation for Kotlin DSL

1. Add the following dependency in your project's `settings.gradle.kts` file:
```kotlin
dependencyResolutionManagement {
  ...
  repositories {
    ...
    mavenCentral()
    maven(url = "https://jitpack.io")
  }
}
```

2. Add the following dependency in your app's `build.gradle.kts` file:
```kotlin
dependencies {
  implementation("com.github.iambhargavnath:messenger-library:v1.0.0")
}
```

## How to use

### 1. Create a layout with a RecyclerView
```Example code in XML
<androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

### 2. Create a Message List
```Example code in Kotlin
import com.iambhargavnath.messengerlibrary.model.Message
...
val messageList = listOf(
  Message(sender = "other", content = "Hi", time = "2024-11-12 10:15:00", profilePicUrl = "https://masterpiecer-images.s3.yandex.net/a7a8505187f411eeb3fc5696910b1137:upscaled"),
  Message(sender = "me", content = "Hey! How's it going?", time = "2024-11-12 10:15:30"),
  Message(sender = "other", content = "Pretty good, thanks! Just finished work.", time = "2024-11-12 10:16:00", profilePicUrl = "https://masterpiecer-images.s3.yandex.net/a7a8505187f411eeb3fc5696910b1137:upscaled"),
  Message(sender = "other", content = "It was a long day, but I got a lot done.", time = "2024-11-12 10:16:15", profilePicUrl = "https://masterpiecer-images.s3.yandex.net/a7a8505187f411eeb3fc5696910b1137:upscaled"),
  Message(sender = "me", content = "Nice! Busy days can be satisfying.", time = "2024-11-12 10:16:30")
)
```
Here `time` and `profilePicUrl` is nullable.

Or you can retrieve messages from server and add to the `messageList`
```
val messageList: List<Message> = retrievedMessagesFromServer
```

### 3. Add the Message List to MessageAdapter
```Example Code in Kotlin
import com.iambhargavnath.messengerlibrary.adapter.MessageAdapter
...
val yourUserId = "me" // Replace 'me' with your username.
val messageAdapter = MessageAdapter(messageList = messageList, yourUserId = yourUserId)
```

### 4. Add the MessageAdapter to the RecyclerView
```Example Code in Kotlin
val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
recyclerView.layoutManager = LinearLayoutManager(this)
recyclerView.adapter = adapter
```

### 5. Add internet permission to download profile image from internet
```Example Code in AndroidManifest.xml
<uses-permission android:name="android.permission.INTERNET" />
```

### Developed by Bhargav Nath
## Find me at
<p align="left">
<a href="https://twitter.com/iambhargavnath" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/twitter.svg" alt="iambhargavnath" height="30" width="40" /></a>
<a href="https://linkedin.com/in/iambhargavnath" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="iambhargavnath" height="30" width="40" /></a>
<a href="https://fb.com/iambhargavnath" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/facebook.svg" alt="iambhargavnath" height="30" width="40" /></a>
<a href="https://instagram.com/iambhargavnath" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/instagram.svg" alt="iambhargavnath" height="30" width="40" /></a>
</p>
