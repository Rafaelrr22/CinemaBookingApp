package pt.rafaelr22.cinemabookingapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import pt.rafaelr22.cinemabookingapp.data.model.Reservation

class BookingViewModel : ViewModel() {

    private val _reservations =
        mutableStateListOf<Reservation>()

    val reservations: List<Reservation>
        get() = _reservations

    fun addReservation(
        movie: String,
        seat: String
    ) {
        _reservations.add(
            Reservation(
                movieTitle = movie,
                seat = seat
            )
        )
    }
}