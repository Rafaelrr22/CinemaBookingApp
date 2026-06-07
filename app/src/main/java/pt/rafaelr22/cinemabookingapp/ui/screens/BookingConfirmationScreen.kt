package pt.rafaelr22.cinemabookingapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BookingConfirmationScreen(
    movieTitle: String,
    seat: String,
    onBackHome: () -> Unit,
    onViewHistory: () -> Unit
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
            text = "Booking Confirmed",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Movie: $movieTitle")
        Text("Seat: $seat")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Booking successful")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onBackHome
        ) {
            Text("Back to Home")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onViewHistory
        ) {
            Text("View History")
        }


    }
}