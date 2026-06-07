package pt.rafaelr22.cinemabookingapp.data.database

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    private var INSTANCE: AppDatabase? = null

    fun getDatabase(
        context: Context
    ): AppDatabase {

        return INSTANCE ?: synchronized(this) {

            val instance = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "cinema_booking_db"
            ).build()

            INSTANCE = instance
            instance
        }
    }
}