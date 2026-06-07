package pt.rafaelr22.cinemabookingapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import pt.rafaelr22.cinemabookingapp.data.model.Reservation
import pt.rafaelr22.cinemabookingapp.data.repository.ReservationRepository

class BookingViewModel(
    private val repository: ReservationRepository
) : ViewModel() {

    val reservations =
        repository.getAllReservations()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )

    val reservedSeats =
        repository.getReservedSeats()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )
    fun addReservation(
        movie: String,
        seat: String
    ) {

        viewModelScope.launch {

            repository.insertReservation(
                Reservation(
                    movieTitle = movie,
                    seat = seat
                )
            )
        }
    }
}