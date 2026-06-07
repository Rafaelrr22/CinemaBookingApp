package pt.rafaelr22.cinemabookingapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pt.rafaelr22.cinemabookingapp.data.model.Reservation
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.fillMaxWidth


@Composable
fun BookingHistoryScreen(
    reservations: List<Reservation>,
    onClearHistory: () -> Unit,
    onBackHome: () -> Unit
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

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onClearHistory
        ) {
            Text("Clear History")
        }

        Spacer(modifier = Modifier.height(8.dp))



        if (reservations.isEmpty()) {

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "No reservations found",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(24.dp))

        } else {

            LazyColumn {

                items(reservations) { reservation ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = "🎬 ${reservation.movieTitle}",
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = "💺 Seat ${reservation.seat}"
                            )
                        }
                    }
                }
            } }



        Button(
            onClick = onBackHome
        ) {
            Text("Return Home")
        }

    }
}