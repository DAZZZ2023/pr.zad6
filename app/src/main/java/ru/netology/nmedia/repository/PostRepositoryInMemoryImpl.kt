package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {

    private var posts = listOf(
        Post(
            id = 2,
            author = "Плугатырев Иван",
            content = "Столица и крупнейший город Нидерландов. Является столицей королевства с 1814 года. Расположен в провинции Северная Голландия на западе страны в устье реки Амстел, у бухты Эй. Амстердам соединён Нордзе-каналом с Северным морем",
            published = "5 минут назад",
            likedByMe = false,
            kolLikes = false,
            kolRep = 12
        ),
        Post(
            id = 2,
            author = "Плугатырев Иван",
            content = "Вчера прилетел в Амстердам, Нидерланды",
            published = "15 минут назад",
            likedByMe = false,
            kolLikes = false,
            kolRep = 12
        ),
        Post(
            id = 3,
            author = "Плугатырев Иван",
            content = "Сегодня улетел из Нидерландов",
            published = "20 минут назад",
            likedByMe = false,
            kolLikes = false,
            kolRep = 12
        ),
        Post(
            id = 2,
            author = "Плугатырев Иван",
            content = "Вчера прилетел в Амстердам, Нидерланды",
            published = "День назад",
            likedByMe = false,
            kolLikes = false,
            kolRep = 12
        ),
    )

    private val data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = data
    override fun likeById(id: Long) {
        posts = posts.map {
           if (it.id != id) it else it.copy(likedByMe = !it.likedByMe)
        }
        data.value = posts
    }
}