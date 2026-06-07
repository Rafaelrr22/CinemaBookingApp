package pt.rafaelr22.cinemabookingapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pt.rafaelr22.cinemabookingapp.data.model.Reservation

@Dao
interface ReservationDao {

    @Insert
    suspend fun insertReservation(
        reservation: Reservation
    )

    @Query("SELECT * FROM reservations")
    fun getAllReservations(): Flow<List<Reservation>>
}