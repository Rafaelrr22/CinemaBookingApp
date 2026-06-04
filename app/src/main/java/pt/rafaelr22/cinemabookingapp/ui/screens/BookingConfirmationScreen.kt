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
            text = "Booking Confirmed",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Movie: Dune: Part Two")
        Text("Seat successfully reserved")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onBackHome
        ) {
            Text("Back to Home")
        }
    }
}