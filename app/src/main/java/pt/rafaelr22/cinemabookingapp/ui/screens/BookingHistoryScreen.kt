package pt.rafaelr22.cinemabookingapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pt.rafaelr22.cinemabookingapp.data.model.Reservation


@Composable
fun BookingHistoryScreen(
    reservations: List<Reservation>
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 48.dp,
                start = 16.dp,
                end = 16.dp
            )
    ) {

        Text(
            text = "Booking History",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))



        LazyColumn {

            items(reservations) { reservation ->

                Text(
                    text =
                        "${reservation.movieTitle} - Seat ${reservation.seat}"
                )
            }
        }
    }
}