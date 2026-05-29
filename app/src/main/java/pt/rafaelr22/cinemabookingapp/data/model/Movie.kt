package pt.rafaelr22.cinemabookingapp.data.model

data class Movie(
    val id: Int,
    val title: String,
    val genre: String,
    val duration: String,
    val description: String,
    val imageUrl: String = ""
)