package pt.rafaelr22.cinemabookingapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pt.rafaelr22.cinemabookingapp.data.repository.ReservationRepository


class BookingViewModelFactory(
    private val repository: ReservationRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(BookingViewModel::class.java)) {

            @Suppress("UNCHECKED_CAST")
            return BookingViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class"
        )
    }
}