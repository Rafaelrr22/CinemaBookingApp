package pt.rafaelr22.cinemabookingapp.data.repository

import kotlinx.coroutines.flow.Flow
import pt.rafaelr22.cinemabookingapp.data.database.ReservationDao
import pt.rafaelr22.cinemabookingapp.data.model.Reservation

class ReservationRepository(
    private val reservationDao: ReservationDao
) {

    fun getAllReservations(): Flow<List<Reservation>> {
        return reservationDao.getAllReservations()
    }

    suspend fun insertReservation(
        reservation: Reservation
    ) {
        reservationDao.insertReservation(reservation)
    }

    fun getReservedSeats(): Flow<List<String>> {
        return reservationDao.getReservedSeats()
    }
}