package pt.rafaelr22.cinemabookingapp.data.model

data class Seat(
    val row: Char,
    val number: Int,
    val isSelected: Boolean = false
)