package pt.rafaelr22.cinemabookingapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class BookingViewModel : ViewModel() {

    private val _reservations = mutableStateListOf<String>()

    val reservations: List<String>
        get() = _reservations

    fun addReservation(
        movie: String,
        seat: String
    ) {
        _reservations.add("$movie - Seat $seat")
    }
}